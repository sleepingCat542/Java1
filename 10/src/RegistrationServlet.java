import db.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value="/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        writer.println(email);
        try {
            UserDao userDao = new UserDao();
            if (userDao.isExists(email)) {
                writer.println("This account already exists");
            } else {
                userDao.addUser(email, password);
                writer.println("Registration complete");
            }
        } catch( SQLException | ClassNotFoundException ex) {
            writer.println("Errored");
            writer.println(ex.getStackTrace());
        }
    }}
