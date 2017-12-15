/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.*;
import dataAccess.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gerar
 */
@WebServlet(name = "ResourcesServlet", urlPatterns = ("/Resources"))
public class ResourcesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "C:\\data";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    /**
     * Upon receiving file upload submission, parses the request to read upload
     * data and saves the file on disk.
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();

        ResourceDAO resourceDao = new ResourceDAO(connection);
        ResourceTypeDAO typeDao = new ResourceTypeDAO(connection);
        AreaDAO areaDao = new AreaDAO(connection);
        FileDAO fileDao = new FileDAO(connection);
        TopicDAO topicDao = new TopicDAO(connection);
        SubtopicDAO subtopicDao = new SubtopicDAO(connection);

        String url = "/index.jsp";
        String mode = request.getParameter("mode");
        String action = request.getParameter("action");
        String area = request.getParameter("area");

        switch (action) {
            case "view":
                switch (mode) {
                    case "table":
                        request.setAttribute("resources", resourceDao.getResources());
                        url = "/tables/resources_table.jsp";
                        break;
                    case "grid":
                        if (area != null) {
                            request.setAttribute("resources", resourceDao.getByArea(area));
                        } else {
                            request.setAttribute("resources", resourceDao.getEnabledResources());
                        }
                        request.setAttribute("areas", areaDao.getEnabledAreas());
                        url = "/grid.jsp";
                        break;
                    case "list":
                        if (area != null) {
                            request.setAttribute("resources", resourceDao.getByArea(area));
                        } else {
                            request.setAttribute("resources", resourceDao.getEnabledResources());
                        }
                        request.setAttribute("areas", areaDao.getEnabledAreas());
                        url = "/list.jsp";
                        break;
                    case "detail":
                        if (resourceDao.getById(request.getParameter("id")).getId() != null) {
                            System.out.println(fileDao.getByResource(request.getParameter("id")).get(0).getType());
                            request.setAttribute("file", fileDao.getByResource(request.getParameter("id")).get(0));
                            request.setAttribute("resource", resourceDao.getById(
                                    request.getParameter("id")));
                            url = "/course-detail.jsp";
                        } else {
                            url = "/page-404.jsp";
                        }
                        break;
                    default:
                        url = "/page-404.jsp";
                }
                break;
            case "add":
                try {
                    request.setAttribute("types", typeDao.getEnabledTypes());
                    request.setAttribute("areas", areaDao.getEnabledAreas());
                    url = "/newResource.jsp";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "edit-form":
                String r_id = request.getParameter("r_id");
                if (r_id != null) {
                    Resource res = resourceDao.getById(r_id);
                    request.setAttribute("types", typeDao.getEnabledTypes());
                    request.setAttribute("areas", areaDao.getEnabledAreas());
                    request.setAttribute("topics", topicDao.getByArea(res.getArea().getId()));
                    request.setAttribute("subtopics", subtopicDao.getByTopic(res.getTopic().getId()));
                    request.setAttribute("resource", res);
                    url = "/forms/updateResource.jsp";
                }
                break;
            case "edit-form2":
                r_id = request.getParameter("r_id");
                Resource res = resourceDao.getById(r_id);
                request.setAttribute("resource", res);
                request.setAttribute("file", fileDao.getByResource(request.getParameter("r_id")).get(0));
                url = "/forms/updateFile.jsp";
                break;
            default:
                break;
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private String youtube_id(String url) {
        String youtube_id = "";
        String regExp = "/.*(?:youtu.be\\/|v\\/|u/\\w/|embed\\/|watch\\?.*&?v=)";
        Pattern compiledPattern = Pattern.compile(regExp);
        Matcher matcher = compiledPattern.matcher(url);
        if (matcher.find()) {
            int start = matcher.end();
            youtube_id = url.substring(start, start + 11);
        }
        return youtube_id;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);

        String uploadPath = UPLOAD_DIRECTORY;

        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.getConnection();

            ResourceDAO resourceDao = new ResourceDAO(connection);

            Date date = new Date();

            HttpSession session = request.getSession();
            User currentUser = (User) session.getAttribute("currentSessionUser");

            FileObj fileObj = new FileObj();
            FileDAO fileDao = new FileDAO(connection);

            Resource resource = new Resource();
            resource.setInstructor(new Instructor(currentUser.getId()));
            resource.setAddedDate(new java.sql.Date(date.getTime()));

            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            List<FileItem> fileItems = new ArrayList<>();

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are  form fields
                    if (item.isFormField()) {
                        //String fieldValue = Streams.asString((InputStream) item, "UTF-8");
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString("UTF-8");
                        switch (fieldName) {
                            case "title":
                                resource.setTitle(fieldValue);
                                break;
                            case "description":
                                resource.setDescription(fieldValue);
                                break;
                            case "references":
                                resource.setReferences(fieldValue);
                                break;
                            case "link":
                                resource.setLink(fieldValue);
                                break;
                            case "type":
                                resource.setType(new ResourceType(fieldValue));
                                break;
                            case "level":
                                resource.setLevel(fieldValue);
                                break;
                            case "area":
                                resource.setArea(new Area(fieldValue));
                                break;
                            case "topic":
                                resource.setTopic(new Topic(fieldValue));
                                break;
                            case "subtopic":
                                resource.setSubtopic(new Subtopic(fieldValue));
                                break;
                            case "video":
                                fileObj.setFilepath("https://www.youtube.com/embed/" + youtube_id(fieldValue));
                                fileObj.setType("video");
                                break;
                        }
                    } else {
                        fileItems.add(item);
                    }
                }
            }
            resource.setId(resource.getSubtopic().getId() + "_R" + String.format("%03d",
                    (resourceDao.getCountBySubtopic(resource.getSubtopic()) + 1)));
            fileObj.setId(resource.getId() + "." + String.valueOf(fileDao.countByResource(resource.getId()) + 1));
            fileObj.setStatus(1);
            fileObj.setResource(new Resource(resource.getId()));

            //Aqui procesar los archivos
            uploadPath += "\\" + resource.getArea().getId() + "\\" + resource.getId();
            // creates the directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            for (FileItem item : fileItems) {
                String fileName = new File(item.getName()).getName();
                String filePath = uploadPath + File.separator + fileName;
                File storeFile = new File(filePath);
                if (item.getFieldName().equals("file")) {
                    resource.setFilePath(resource.getArea().getId() + "/" + resource.getId() + "/" + fileName);
                } else {
                    fileObj.setFilepath(resource.getArea().getId() + "/" + resource.getId() + "/" + fileName);
                    fileObj.setType(item.getFieldName());
                }
                // saves the file on diskfile
                item.write(storeFile);
            }
            resourceDao.add(resource);
            fileDao.add(fileObj);
            request.setAttribute("message",
                    "Recurso guardado con éxito.");
            request.setAttribute("resource", resource.getId());

        } catch (Exception ex) {
            request.setAttribute("message", "Hubo un problema...");
            request.setAttribute("information",
                    "There was an error: " + ex.getMessage());
        }
        getServletContext()
                .getRequestDispatcher("/uploaded.jsp").forward(
                request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
