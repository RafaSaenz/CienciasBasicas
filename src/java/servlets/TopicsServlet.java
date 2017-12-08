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
@WebServlet(name = "TopicsServlet", urlPatterns = {"/Topics"})
public class TopicsServlet extends HttpServlet {

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

        AreaDAO areaDao = new AreaDAO(connection);
        TopicDAO topicDao = new TopicDAO(connection);

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String area = request.getParameter("area");
        String name = request.getParameter("name");

        switch (action) {
            case "select":
                topicDao = new TopicDAO(connection);
                for (Topic topic1 : topicDao.getEnabledByArea(area)) {
                    data += "<option value='" + topic1.getId() + "'>"
                            + topic1.getName() + "</option>";
                }
                out.print(data);
                break;
            case "show":
                request.setAttribute("area", areaDao.getById(area));
                request.setAttribute("topics", topicDao.getByArea(area));
                getServletContext().getRequestDispatcher("/tables/topics_table.jsp").forward(request, response);
                break;
            case "add":
                try {
                    topicDao.add(
                            new Topic(area + "_T"
                                    + String.format("%03d",
                                            (topicDao.getCountByArea(new Area(area)) + 1)),
                                    id, area, 1));
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "disable":
                try {
                    topicDao.disable(id);
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "enable":
                try {
                    topicDao.enable(id);
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "update":
                try {
                    topicDao.update(new Topic(id, name));
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
