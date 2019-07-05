package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Time")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("Date: "+new Date()+
                "<br>Protocol: "+req.getProtocol()+
                "<br>Address: "+req.getRemoteAddr()+
                "<br>URI: "+req.getRequestURI()+
                "<br>Method: "+req.getMethod()+
                "<br><br><a href=\"index2.jsp\">Task 2</a>");
    }
}
