package mainpackage;

import beans.contracts.IDataSource;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Objects;

@WebServlet(name = "Device", urlPatterns = "/add")
public class Device  extends HttpServlet {
    @EJB
    IDataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()){
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add device</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Добавить устройство</h1>");
            out.println("<div>");
            out.println("<form action=\"/add\" method=\"post\"></br>");
            out.println("Производитель: <input type=\"text\" name=\"vendor\"></br>");
            out.println("Модель: <input type=\"text\" name=\"model\"></br>");
            out.println("Дата производства: <input type=\"date\" name=\"date\"></br>");
            out.println("<input type=\"submit\" value=\"Добавить\">");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String vendor = Objects.toString(req.getParameter("vendor"),"").trim();
        String model = Objects.toString(req.getParameter("model"),"").trim();
        String date = Objects.toString(req.getParameter("date"),"").trim();

        if (!vendor.isEmpty() && !model.isEmpty() && !date.isEmpty()){
            dataSource.createDevice(vendor, model, Date.valueOf(date));
        }
        resp.sendRedirect("/devices");
    }
}
