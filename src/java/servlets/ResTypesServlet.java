/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.*;
import com.google.gson.Gson;
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
@WebServlet(name = "ResTypesServlet", urlPatterns = {"/ResTypes"})
public class ResTypesServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String data = "<option style=\"display:none\"></option>";

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();

        ResourceTypeDAO resTypeDao = new ResourceTypeDAO(connection);

        String action = request.getParameter("action");
        String description = request.getParameter("description");
        String id = request.getParameter("id");

        switch (action) {
            case "select":
                /*String json = new Gson().toJson(areaDao.getEnabledAreas());
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);*/
                break;
            case "show":
                request.setAttribute("types", resTypeDao.getTypes());
                getServletContext().getRequestDispatcher("/tables/res_types_table.jsp").forward(request, response);
                break;
            case "add":
                try {
                    resTypeDao.add(new ResourceType(String.valueOf(resTypeDao.getCount()+1), description, 1));
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "disable":
                try {
                    resTypeDao.disable(id);
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "enable":
                try {
                    resTypeDao.enable(id);
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "update":
                try {
                    resTypeDao.update(new ResourceType(id, description));
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
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
