package servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet{

    private final static Logger logger = LogManager.getLogger(TestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

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
            writer.print("</body>");
            writer.print("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

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
            writer.print("</body>");
            writer.print("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
