/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Student;
import dataAccess.StudentDAO;
import dataAccess.ConnectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rafa S
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        try
        {	    
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.getConnection();
            
            //Create object and get the parameters from the register form
            Student student = new Student();
            student.setEmail(request.getParameter("un"));
            student.setPassword(request.getParameter("pw"));
            
            //StudentDao will help validate the user information
            StudentDAO studentDAO = new StudentDAO(connection);
            studentDAO.login(student);

             if (student.isValid())
             {
               
                HttpSession session = request.getSession();
                session.setAttribute("currentSessionUser",student);
                System.out.println(session.getAttribute("currentSessionUser"));
                
                response.sendRedirect("index.jsp"); //Change for index according to user   		
             }
             else 
                  response.sendRedirect("login-register.jsp"); //error page 
        } 
        catch (Throwable theException) 	    
        {
             System.out.println(theException); 
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
        
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
