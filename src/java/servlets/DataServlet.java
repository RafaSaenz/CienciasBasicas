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
@WebServlet(name = "DataServlet", urlPatterns = {"/DataServlet"})
public class DataServlet extends HttpServlet {

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

        String mode = null, newTopic = null, items = request.getParameter("items");
        
        ResourceDAO resourceDao;
        switch (items) {
            case "resources":
                resourceDao = new ResourceDAO(connection);
                mode = request.getParameter("action");
                newTopic = request.getParameter("id");
                switch (mode) {
                    case "show":
                        request.setAttribute("resources", resourceDao.getResources());
                        getServletContext().getRequestDispatcher("/tables/resources_table.jsp").forward(request, response);
                        break;
                    case "enable":
                        try {
                            resourceDao.enable(newTopic);
                        } catch (Exception e) {
                            request.setAttribute("message", e.getMessage());
                            getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                        }
                        break;
                    case "disable":
                        try {
                            resourceDao.disable(newTopic);
                        } catch (Exception e) {
                            request.setAttribute("message", e.getMessage());
                            getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                        }
                        break;
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
