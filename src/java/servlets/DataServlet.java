/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Subtopic;
import business.Topic;
import dataAccess.ConnectionDB;
import dataAccess.SubtopicDAO;
import dataAccess.TopicDAO;
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
        String items = request.getParameter("items");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String data = "<option style=\"display:none\"></option>";

        switch (items) {
            case "topics":
                String area = request.getParameter("area");
                TopicDAO topicDao = new TopicDAO(connection);
                for (Topic topic1 : topicDao.findByArea(area)) {                  
                    data += "<option value='" + topic1.getId() + "'>"
                            + topic1.getName() + "</option>";
                }
                break;
            case "subtopics":
                String topic = request.getParameter("topic");
                SubtopicDAO subtopicDao = new SubtopicDAO(connection);
                for (Subtopic subtopic : subtopicDao.findByTopic(topic)) {                    
                    data += "<option value='" + subtopic.getId() + "'>"
                            + subtopic.getName() + "</option>";
                }
                break;
        }
        out.print(data);
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
