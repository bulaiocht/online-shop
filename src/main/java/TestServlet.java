import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Kocherha Vitalii on 05.12.2017.
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("<! DOCTYPE html>");
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>");
        writer.print("Title");
        writer.print("</title>");
        writer.print("<meta charset='UTF-8'/>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<h1>Hello at " + new Date());
        writer.print("</h1>");
        writer.print("</body>");
        writer.print("</html>");
    }
}
