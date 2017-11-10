/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.Student;
import dataAccess.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;


/**
 *
 * @author Rafa S
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //Copying all the input parameters in to local variables
            String id = request.getParameter("id");
            String firstName = request.getParameter("firstName");
            String lastName1 = request.getParameter("lastName1");
            String lastName2 = request.getParameter("lastName2");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String major= request.getParameter("major"); 
            
            //Get the current Date for joinDate
            LocalDate joinDate = LocalDate.now( ZoneId.of( "America/Montreal" ) );
        
            //Using Java Beans
            Student newStudent = new Student();
            newStudent.setId(id);
            newStudent.setFirstName(firstName);
            newStudent.setLastName1(lastName1);
            newStudent.setLastName2(lastName2);
            newStudent.setEmail(email);
            newStudent.setPassword(password); 
            newStudent.setMajor(major);
            newStudent.setJoinDate(joinDate);
            //After creating the object we connect to the DB
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.getConnection();
            
            //Call the method from StudentDAO to register a new student
            StudentDAO studentDAO = new StudentDAO(connection);
            String userRegistered = studentDAO.registerStudent(newStudent);
            
            
            if(userRegistered.equals("SUCCESS"))    //On SUCCESS, it means that the registration was successful
            {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else   //On Failure TO-DO
            {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/login-register.jsp").forward(request, response);
            }
        }
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
        processRequest(request, response);

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
