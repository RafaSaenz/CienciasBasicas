/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Area;
import business.EmailValidator;
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
import dataAccess.TopicDAO;
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
@WebServlet(name = "StudentsServlet", urlPatterns = {"/Students"})
public class StudentServlet extends HttpServlet {
    
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
        String id = request.getParameter("id");
        
        
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();
        
        AreaDAO areaDao;
        
        UserDAO userDAO = new UserDAO(connection);
        
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
                            case "table":
                                request.setAttribute("users", userDAO.getAllInstructors());
                                url = "/tables/instructors_table.jsp";
                                break;
                                
                            case "tableStudents":
                                request.setAttribute("users", userDAO.getAllStudents());
                                url = "/tables/students_table.jsp";
                                break;
                            default:
                                url = "/page-404.jsp";
                        }
                    }
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
                }
                break;
            case "disable":
                try {
                    userDAO.disable(id);;
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "enable":
                try {
                    userDAO.enable(id);
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
                
            case "add":
                    String stu_id = request.getParameter("stu_id");
                    try {
                    userDAO = new UserDAO(connection);
                    if (stu_id != null) {
                        request.setAttribute("user", userDAO.getInstructorsById(stu_id));
                    }
                    url = "/newStudent.jsp";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
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
            
            User newStudent = new User();

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
                                newStudent.setId(fieldValue);
                                break;
                            case "firstname":
                                newStudent.setFirstName(fieldValue);
                                break;
                            case "lastname1":
                                newStudent.setLastName1(fieldValue);
                                break;
                            case "lastname2":
                                newStudent.setLastName2(fieldValue);
                                break;
                            case "email":
                                newStudent.setEmail(fieldValue);
                                break;
                            case "password":
                                newStudent.setPassword(fieldValue);
                                break;
                            case "major":
                                newStudent.setMajor(fieldValue);
                                break;
                        }
                        LocalDate joinDate = LocalDate.now( ZoneId.of( "America/Montreal" ) );
                        newStudent.setJoinDate(joinDate);
                        newStudent.setRole("3");
                    } else {
                        fileItems.add(item);
                    }
                }
            }
            //Call the method from StudentDAO to register a new student
            String userUpdate = null;
            String userRegistered = null;
            
            if(userDAO.validUser(newStudent.getId())){
                //Check if the user updated the password or not
                
                if(newStudent.getPassword().equals(userDAO.passwordStudentModified(newStudent.getId()))){
                    userUpdate = userDAO.updateStudent(newStudent);
                    request.setAttribute("message", "Estudiante guardado con éxito.");
                    request.setAttribute("resource", newStudent.getId());
                    getServletContext()
                    .getRequestDispatcher("/uploaded.jsp").forward(
                    request, response);
                }
                else{
                    userUpdate = userDAO.updateStudentPassword(newStudent);
                    request.setAttribute("message", "Estudiante guardado con éxito.");
                    request.setAttribute("resource", newStudent.getId());
                    getServletContext()
                    .getRequestDispatcher("/uploaded.jsp").forward(
                    request, response);
                }
                
            }
            else{
                userRegistered = userDAO.registerUser(newStudent);
            }
            request.setAttribute("message", "Estudiante guardado con éxito.");
            request.setAttribute("resource", newStudent.getId());
            
            if(userUpdate.equals("SUCCESS"))//On SUCCESS, it means that the registration was successful
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
