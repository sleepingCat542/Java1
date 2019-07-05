import dao.User;
import dao.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    private UserDAO dao;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        dao = new UserDAO();

        dao.add(new User(1, "admin", "admin", User.ROLE.ADMIN));
        dao.add(new User(1, "yuliana", "123456", User.ROLE.USER));

        final ServletContext servletContext = sce.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}
