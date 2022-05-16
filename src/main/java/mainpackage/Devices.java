/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import API.DTO.DeviceDTO;
import beans.contracts.IDataSource;
import beans.contracts.IFilterAdapter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author denis
 */
@WebServlet(name = "Devices", urlPatterns = {"/devices"})
public class Devices extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    IDataSource dataSource;

    @EJB
    IFilterAdapter filterAdapter;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Devices list</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<div>");
            out.print("<form action=\"/devices\" method=\"GET\">");
            out.print("<p>Фильтр:</p>");
            out.print("Производитель: <input type=\"text\" name=\"vendor\"> <br/>");
            out.print("Модель: <input type=\"text\" name=\"model\"> <br/>");
            out.print("Дата производства: <input type=\"date\" name=\"dateFrom\"> <input type=\"date\" name=\"dateTo\"><br/>");
            out.print("<input type=\"submit\" value=\"Применить\"> <br/>");
            out.print("</form>");
            out.print("</div>");
            out.print("<table border=\"1\">");
            out.print("<th>");
            out.print("<tr>");
            out.print("<td>Номер</td>");
            out.print("<td>Вендор</td>");
            out.print("<td>Модель</td>");
            out.print("<td>Дата производства</td>");
            out.print("</tr>");
            out.print("</th>");
            out.print("<tbody>");

            List<DeviceDTO> deviceList = filterAdapter.filter(request);

            for (DeviceDTO d : deviceList) {
                out.print("<tr>");
                out.printf("<td>%d</td>", d.getId());
                out.printf("<td>%s</td>", d.getVendor());
                out.printf("<td>%s</td>", d.getModel());
                out.printf("<td>%s</td>", d.getDate().toString());
                out.print("</tr>");
            }

            out.print("</tbody>");
            out.print("</table>");
            out.print("<a href=/add>Добавить устройство</a>");
            out.print("</body>");
            out.print("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sessionId = request.getSession().getId();
        if (!Person.checkSessionId(sessionId)) {
            response.sendRedirect("http://localhost:8080/auth/");
        } else {
            processRequest(request, response);
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!Person.checkSessionId(request.getSession().getId())) {
            response.sendRedirect("http://localhost:8080/auth/");
        } else {
            processRequest(request, response);
        }
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
