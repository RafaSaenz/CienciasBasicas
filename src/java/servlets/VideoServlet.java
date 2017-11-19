/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gerar
 */
@WebServlet(name = "VideoServlet", urlPatterns = {"/video/*"})
public class VideoServlet extends HttpServlet {

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
        Enumeration<String> enumn = request.getHeaderNames();
        while (enumn.hasMoreElements()) {
            String hr = enumn.nextElement();
            System.out.println(hr + " - " + request.getHeader(hr));
        }

        String fileName = "love.mp4";
        String filePath = "C:\\data\\love.mp4";

        String range = request.getHeader("range");
        File file = new File(filePath);
        long fileLength = file.length();

        response.setContentType("video/mp4");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-control", "private");
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Etag", "W/\"9767057-1323779115364\"");
        response.setHeader("Connection", "keep-alive");

        response.setBufferSize((int) fileLength + 200);
        response.setContentLength((int) fileLength);
        response.setHeader("Content-Type", "video/mp4");
        response.setHeader("Content-Length", String.valueOf(file.length()));

        BufferedInputStream input = null;
        BufferedOutputStream output = null;
        try {

            input = new BufferedInputStream(new FileInputStream(file));
            output = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[(int) fileLength];
            for (int length = 0; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
            response.flushBuffer();
            System.out.println("buffer length : " + buffer.length);
            response.setHeader("Content-Range", "0-" + Integer.valueOf(buffer.length - 1));
            System.out.println("=======================================================================");
            for (String hr : response.getHeaderNames()) {
                System.out.println(hr + " - " + response.getHeader(hr));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException logOrIgnore) {
                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException logOrIgnore) {
                }
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
