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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
                            request.setAttribute("resource", resourceDao.getById(
                                    request.getParameter("id")));
                            url = "/course-detail.jsp";
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
                url = "/upload.jsp";
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
        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = UPLOAD_DIRECTORY;
        //getServletContext().getRealPath("")
        //+ File.separator + UPLOAD_DIRECTORY;
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.getConnection();
            ResourceDAO resourceDao = new ResourceDAO(connection);
            Resource resource = new Resource();
            resource.setId(String.valueOf(resourceDao.getCount() + 1));
            resource.setInstructor(new Instructor("L00000001"));
            resource.setAddedDate(new java.sql.Date(117, 10, 12));

            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // saves the file on diskfile
                        item.write(storeFile);
                        resource.setFilePath(uploadPath += "\\" + fileName);
                        resourceDao.add(resource);
                        request.setAttribute("message",
                                "Recurso guardado con éxito.");
                        request.setAttribute("resource","7");
                    } else {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();
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
                                uploadPath += "\\" + fieldValue;
                                break;
                            case "topic":
                                resource.setTopic(new Topic(fieldValue));
                                break;
                            case "subtopic":
                                resource.setSubtopic(new Subtopic(Integer.parseInt(fieldValue)));
                                break;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Hubo un problema...");
            request.setAttribute("information",
                    "There was an error: " + ex.getMessage());
        }
        // redirects client to message page
        getServletContext().getRequestDispatcher("/uploaded.jsp").forward(
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
