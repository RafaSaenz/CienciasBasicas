/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.*;
import dataAccess.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

/**
 *
 * @author gerar
 */
@WebServlet(name = "ResourceListServlet", urlPatterns = ("/Resources"))
public class ResourceListServlet extends HttpServlet {

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
        String url = "/index.jsp";
        String mode = request.getParameter("mode");
        String action = request.getParameter("action");
        if (action.equals("view")) {
            try {
                ConnectionDB connectionDB = new ConnectionDB();
                Connection connection = connectionDB.getConnection();
                ResourceDAO resourceDao = new ResourceDAO(connection);
                if (!resourceDao.getResources().isEmpty()) {
                    request.setAttribute("resources", resourceDao.getResources());
                    switch (mode) {
                        case "grid":
                            url = "/courses-gride.jsp";
                            break;
                        case "list":
                            url = "/courses-list.jsp";
                            break;
                        case "detail":
                            if (resourceDao.getById(request.getParameter("id")).getId() != null) {
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
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (action.equals("add")) {
            try {
                ConnectionDB connectionDB = new ConnectionDB();
                Connection connection = connectionDB.getConnection();
                /*Types for the select box*/
                ResourceTypeDAO typeDao = new ResourceTypeDAO(connection);
                request.setAttribute("types", typeDao.getTypes());
                /*Areas for the select box*/
                AreaDAO areaDao = new AreaDAO(connection);
                request.setAttribute("areas", areaDao.getAreas());
                url = "/newResource.jsp";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (action.equals("manage")) {
            try {
                ConnectionDB connectionDB = new ConnectionDB();
                Connection connection = connectionDB.getConnection();
                /*Types for the select box
                ResourceTypeDAO typeDao = new ResourceTypeDAO(connection);
                request.setAttribute("types", typeDao.getTypes());
                /*Areas for the select box*/
                AreaDAO areaDao = new AreaDAO(connection);
                request.setAttribute("areas", areaDao.getAreas());
                url = "/adminPanel.jsp";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
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

            Resource resource = new Resource();
            SubtopicDAO subtopicDao = new SubtopicDAO(connection);
            Date date = new Date();

            resource.setInstructor(new Instructor("L00000001"));
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
                        }
                    } else {
                        fileItems.add(item);
                    }
                }
            }
            resource.setId(resource.getSubtopic().getId() + "_R" + String.format("%03d",
                                                (resourceDao.getCountBySubtopic(resource.getSubtopic())+1)));
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
                // saves the file on diskfile
                item.write(storeFile);
                resource.setFilePath(resource.getArea().getId() + "/" + resource.getId() + "/" + fileName);
            }
            resourceDao.add(resource);
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
