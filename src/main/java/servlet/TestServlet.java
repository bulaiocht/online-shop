package servlet;

import dal.AbstractPortFactory;
import dal.MySQLAdapterFactory;
import dal.PostgresqlAdapterFactory;
import dal.port.UserPort;
import domain.QuizUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/test")
public class TestServlet extends HttpServlet{

    private final static Logger logger = LogManager.getLogger(TestServlet.class);

    private AbstractPortFactory factory  = new MySQLAdapterFactory();

    private UserPort userPort = factory.getUserPort();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        List<QuizUser> users = userPort.getAllUsers();

        try(PrintWriter writer = resp.getWriter()) {
            writer.print("<! DOCTYPE html>");
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<title>");
            writer.print("Title");
            writer.print("</title>");
            writer.print("<meta charset='UTF-8'/>");
            writer.print("</head>");
            writer.print("<body>");
            for (QuizUser user : users) {
                logger.info(user.getUsername());
                writer.print("<p>" + user.toString() + "</p>");
            }
            writer.print("</body>");
            writer.print("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
