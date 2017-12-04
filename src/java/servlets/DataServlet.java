/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Area;
import business.Subtopic;
import business.Topic;
import dataAccess.AreaDAO;
import dataAccess.ConnectionDB;
import dataAccess.ResourceDAO;
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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();

        String area = null, topic, mode = null, newTopic = null, items = request.getParameter("items");
        String data = "<option style=\"display:none\"></option>";

        TopicDAO topicDao;
        AreaDAO areaDao;
        SubtopicDAO subtopicDao;
        ResourceDAO resourceDao;
        switch (items) {
            case "topics":
                area = request.getParameter("area");
                topicDao = new TopicDAO(connection);
                for (Topic topic1 : topicDao.getEnabledByArea(area)) {
                    data += "<option value='" + topic1.getId() + "'>"
                            + topic1.getName() + "</option>";
                }
                break;
            case "subtopics":
                topic = request.getParameter("topic");
                subtopicDao = new SubtopicDAO(connection);
                for (Subtopic subtopic : subtopicDao.getEnabledByTopic(topic)) {
                    data += "<option value='" + subtopic.getId() + "'>"
                            + subtopic.getName() + "</option>";
                }
                break;
            case "topics_table":
                areaDao = new AreaDAO(connection);
                topicDao = new TopicDAO(connection);

                mode = request.getParameter("mode");
                area = request.getParameter("area");
                newTopic = request.getParameter("newTopic");

                switch (mode) {
                    case "show":
                        request.setAttribute("area", areaDao.getById(area));
                        request.setAttribute("topics", topicDao.getByArea(area));
                        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
                        break;
                    case "input":
                        request.setAttribute("area", area);
                        getServletContext().getRequestDispatcher("/adding.jsp").forward(request, response);
                        break;
                    case "add":
                        topicDao.add(
                                new Topic(area + "_T"
                                        + String.format("%03d",
                                                (topicDao.getCountByArea(new Area(area)) + 1)),
                                        newTopic, area, 1));
                        request.setAttribute("area", areaDao.getById(area));
                        request.setAttribute("topics", topicDao.getByArea(area));
                        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
                        break;
                    case "disable":
                        try {
                            topicDao.disable(newTopic);
                            request.setAttribute("area", areaDao.getById(area));
                            request.setAttribute("topics", topicDao.getByArea(area));
                            getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
                        } catch (Exception e) {
                            request.setAttribute("message", "Error, registros de subtemas asociados.");
                            getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                        }
                        break;
                    case "enable":
                        try {
                            topicDao.enable(newTopic);
                            request.setAttribute("area", areaDao.getById(area));
                            request.setAttribute("topics", topicDao.getByArea(area));
                            getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
                        } catch (Exception e) {
                            request.setAttribute("message", "Error, registros de subtemas asociados.");
                            getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                        }
                        break;
                    case "edit":
                        request.setAttribute("area", area);
                        request.setAttribute("topic", topicDao.getById(newTopic));
                        getServletContext().getRequestDispatcher("/updating.jsp").forward(request, response);
                        break;
                    case "update":

                        topicDao.update(new Topic(request.getParameter("newId"), newTopic));
                        request.setAttribute("area", areaDao.getById(area));
                        request.setAttribute("topics", topicDao.getByArea(area));
                        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
                        break;
                }
                break;
            case "resources":
                resourceDao = new ResourceDAO(connection);

                mode = request.getParameter("mode");
                area = request.getParameter("area");
                newTopic = request.getParameter("newTopic");
                switch (mode) {
                    case "show":
                        request.setAttribute("resources", resourceDao.getResources());
                        getServletContext().getRequestDispatcher("/table_r.jsp").forward(request, response);
                        break;
                    case "delete":
                        try {
                            resourceDao.delete(newTopic);
                            //request.setAttribute("area", areaDao.getById(area));
                            request.setAttribute("resources", resourceDao.getResources());
                            getServletContext().getRequestDispatcher("/table_r.jsp").forward(request, response);
                        } catch (Exception e) {
                            request.setAttribute("message", "Error, registros de subtemas asociados.");
                            getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                        }
                        System.out.println(mode + "" + area + newTopic);
                        break;
                }
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
