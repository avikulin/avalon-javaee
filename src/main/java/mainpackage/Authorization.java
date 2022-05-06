/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denis
 */
@WebServlet(name = "Authorization", urlPatterns = {"/auth"})
public class Authorization extends HttpServlet {
    HttpServletRequest request;

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
        this.request = request;
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(!checkParameters(login, password)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("/devices");
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
    
    private boolean checkParameters(String login, String password){
        
        if(login.isEmpty()) {
            request.setAttribute("msgError", "Не валидный логин");
            return false;
        }
        if(password.isEmpty()) {
            request.setAttribute("msgError", "Не валидный пароль");
            return false;
        }
        for(Person p : Person.personList){
            if(p.getLogin().equals(login)){
                if(p.getPassword().equals(password)){
                    p.setSessionId(request.getSession().getId());
                    request.setAttribute("sessionId", p.getSessionId());
                    return true;
                }
            }
        }
        request.setAttribute("msgError", "Логин или пароль не найдены");
        return false;
    }
}
