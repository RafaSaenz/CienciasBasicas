/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Area;
import business.EmailValidator;
import business.Info;
import business.Instructor;
import business.Resource;
import business.ResourceType;
import business.Subtopic;
import business.Topic;
import business.User;
import dataAccess.AreaDAO;
import dataAccess.ConnectionDB;
import dataAccess.InstructorDAO;
import dataAccess.ResourceDAO;
import dataAccess.ResourceTypeDAO;
import dataAccess.SubtopicDAO;
import dataAccess.UserDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author gerar
 */
@WebServlet(name = "InstructorsServlet", urlPatterns = {"/Instructors"})
public class InstructorsServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "C:\\data";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

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
        
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();
        
        ResourceDAO resourceDao;
        ResourceTypeDAO typeDao;
        AreaDAO areaDao;
        
        UserDAO userDAO;
        
        switch (action) {
            case "view":
                try {
                    userDAO = new UserDAO(connection);
                    if (!userDAO.getInstructors().isEmpty()) {
                        request.setAttribute("users", userDAO.getInstructors());
                        switch (mode) {
                            case "grid":
                                url = "/instructors.jsp";
                                break;
                            case "list":
                                url = "/instructors-list.jsp";
                                break;
                            case "detail":
                                if (userDAO.getInstructorsById(request.getParameter("id")).getId() != null) {
                                    request.setAttribute("instructor", userDAO.getInstructorsById(
                                            request.getParameter("id")));
                                    url = "/instructor-profile.jsp";
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
                }   break;
            
            case "add":
                String r_id = request.getParameter("r_id");
                try {           
                    /*Types for the select box*/
                    typeDao = new ResourceTypeDAO(connection);
                    resourceDao = new ResourceDAO(connection);
                    request.setAttribute("types", typeDao.getEnabledTypes());
                    /*Areas for the select box*/
                    areaDao = new AreaDAO(connection);
                    request.setAttribute("areas", areaDao.getEnabledAreas());                    
                    if (r_id != null) {
                        request.setAttribute("resource", resourceDao.getById(r_id));
                    }
                    url = "/newResource.jsp";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }   break;
            case "manage":
                try {
                    areaDao = new AreaDAO(connection);
                    request.setAttribute("areas", areaDao.getAreas());
                    url = "/adminPanel.jsp";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }   break;
            default:
                break;
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
        /*
        String url = "/index.jsp";
        String id = request.getParameter("id");
        if (true) {
            try {
                ConnectionDB connectionDB = new ConnectionDB();
                Connection connection = connectionDB.getConnection();

                InstructorDAO instructorDao = new InstructorDAO(connection);
                Instructor instructor = instructorDao.findById(id);
                if (instructor != null) {
                    request.setAttribute("instructor", instructorDao.findById(id));
                    url = "/instructor-profile.jsp";
                }
                else {
                    url = "/page-404.jsp";
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);*/

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
            
            UserDAO userDAO = new UserDAO(connection);
            //Date date = new Date();
            
            //HttpSession session = request.getSession();
            //User currentUser = (User) session.getAttribute("currentSessionUser");
            
            User newInstructor = new User();

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
                            case "id":
                                newInstructor.setId(fieldValue);
                                break;
                            case "firstname":
                                newInstructor.setFirstName(fieldValue);
                                break;
                            case "lastname1":
                                newInstructor.setLastName1(fieldValue);
                                break;
                            case "lastname2":
                                newInstructor.setLastName2(fieldValue);
                                break;
                            case "email":
                                newInstructor.setEmail(fieldValue);
                                break;
                            case "password":
                                newInstructor.setPassword(fieldValue);
                                break;
                            case "tel":
                                newInstructor.setTel(fieldValue);
                                break;
                            case "linkedin":
                                newInstructor.setLinkedin(fieldValue);
                                break;   
                        }
                        newInstructor.setMajor(" ");
                        LocalDate joinDate = LocalDate.now( ZoneId.of( "America/Montreal" ) );
                        newInstructor.setJoinDate(joinDate);
                        newInstructor.setRole("2");
                        //newInstructor.setStatus(1);
                        
                    } else {
                        fileItems.add(item);
                    }
                }
            }            //Aqui procesar los archivos
            uploadPath += "\\" + newInstructor.getId();
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
                newInstructor.setPicPath(newInstructor.getId() + "/" + fileName);
            }
            
            //Call the method from StudentDAO to register a new student
            String userRegistered = userDAO.registerUser(newInstructor);
            
            request.setAttribute("message", "Instructor guardado con éxito.");
            request.setAttribute("resource", newInstructor.getId());
            
            if(userRegistered.equals("SUCCESS"))//On SUCCESS, it means that the registration was successful
            {
                getServletContext()
                .getRequestDispatcher("/uploaded.jsp").forward(
                request, response);
            }
            
        } catch (Exception ex) {
            request.setAttribute("message", "Hubo un problema...");
            request.setAttribute("information",
                    "There was an error: " + ex.getMessage());
        }
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
