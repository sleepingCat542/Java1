import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import utils.TimeInfo;

@WebServlet(value="/getTime")
public class ServletTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.protocol = req.getProtocol();
        timeInfo.remoteAddress = req.getRemoteAddr();
        timeInfo.url = req.getRequestURI();
        timeInfo.method = req.getMethod();
        timeInfo.date = new Date();
        timeInfo.userAgent = req.getHeader("User-agent");

        resp.setContentType("text/json");
        String jsonResp = gson.toJson(timeInfo);
        writer.print(jsonResp);
    }
}
