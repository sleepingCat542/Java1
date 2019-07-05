import db.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value="/login")
public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        try {
            UserDao userDao = new UserDao();
            if (userDao.checkFor(email, password)) {
                writer.println("Hello, " + email);
                writer.println("Set to cookies");
                writer.println("Last login: " + userDao.getLoginTimestamp(email));
                writer.println("Login number: " + userDao.getLoginNumber(email));
                resp.addCookie(new Cookie("last_login", userDao.getLoginTimestamp(email).toString()));
                resp.addCookie(new Cookie("login_number", Integer.toString(userDao.getLoginNumber(email)) ));
            }else {
                writer.println("Access denied");
            }
        } catch( SQLException | ClassNotFoundException ex) {
            writer.println("Errored");
            writer.println(ex.getStackTrace());
        }
    }
}
