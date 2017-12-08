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
@WebServlet(name = "SubtopicsServlet", urlPatterns = {"/Subtopics"})
public class SubtopicsServlet extends HttpServlet {

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

        TopicDAO topicDao = new TopicDAO(connection);
        SubtopicDAO subtopicDao = new SubtopicDAO(connection);

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String topic = request.getParameter("topic");
        String name = request.getParameter("name");

        switch (action) {
            case "select":
                for (Subtopic subtopic : subtopicDao.getEnabledByTopic(topic)) {
                    data += "<option value='" + subtopic.getId() + "'>"
                            + subtopic.getName() + "</option>";
                }
                out.print(data);
                break;
            case "show":
                request.setAttribute("topic", topicDao.getById(topic));
                request.setAttribute("subtopics", subtopicDao.getByTopic(topic));
                getServletContext().getRequestDispatcher("/tables/subtopics_table.jsp").forward(request, response);
                break;
            case "add":
                try {
                    subtopicDao.add(new Subtopic(topic+"_S"+String.format("%03d", subtopicDao.getCountByTopic(new Topic(topic))+1), id, topic, 1));
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "disable":
                try {
                    subtopicDao.disable(id);
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "enable":
                try {
                    subtopicDao.enable(id);
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                }
                break;
            case "update":
                try {
                    subtopicDao.update(new Subtopic(id, name));
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
