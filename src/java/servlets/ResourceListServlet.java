/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataAccess.ConnectionDB;
import dataAccess.ResourceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gerar
 */
@WebServlet(name = "ResourceListServlet", urlPatterns = ("/Resources"))
public class ResourceListServlet extends HttpServlet {

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
        String ID = request.getParameter("ID");
        if (true) {
            try {
                ConnectionDB connectionDB = new ConnectionDB();
                Connection connection = connectionDB.getConnection();

                ResourceDAO resourceDao = new ResourceDAO(connection);
                if (!resourceDao.getResources().isEmpty()) {
                    request.setAttribute("resources", resourceDao.getResources());
                    switch(mode){
                        case "grid": url = "/courses-gride.jsp"; break;
                        case "list": url = "/courses-list.jsp"; break;
                        default: url = "/page-404.jsp";
                    }                
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } /*else {
            try {
                ConnectionDB connectionDB = new ConnectionDB();
                Connection connection = connectionDB.getConnection();

                ResourceDAO resourceDao = new ResourceDAO(connection);
                if (!resourceDao.getResourceByID(ID).isEmpty()) {
                    request.setAttribute("resources", resourceDao.getResources());
                    url = "/courses-detail.jsp";
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }*/

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
