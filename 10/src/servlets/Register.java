package servlets;

import dao.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();

        final UserDAO userDao = (UserDAO) req.getServletContext().getAttribute("dao");
        if (userDao.userIsExist(login, password)) {
            writer.println("User " + login+" already exists");
        }else {
            User user = new User(5, login,password, User.ROLE.USER);
            userDao.add(user);
            req.getRequestDispatcher("index2.jsp").forward(req, resp);
        }
    }
}
