package filters;

import dao.User;
import dao.UserDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebFilter("/Auth")
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();

        final UserDAO userDao = (UserDAO) req.getServletContext().getAttribute("dao");
        if (userDao.userIsExist(login, password)) {
            writer.println("Hello, " + login+"\nRole"+userDao.getRoleByLoginPassword(login, password)+"\nDate: "+new Date());
            User user = userDao.getUserByLoginPassword(login, password);
            writer.println("Set to cookies");
            writer.println("Last login: " + user.getLastLogin());
            writer.println("Login number: " + user.getTimesLogin());
            resp.addCookie(new Cookie("last_login", user.getLastLogin().toString()));
            resp.addCookie(new Cookie("login_number", Integer.toString(user.getTimesLogin()) ));
            user.setLastLogin(new Date());
            int count = user.getTimesLogin()+1;
            user.setTimesLogin(count);
        }else {
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
