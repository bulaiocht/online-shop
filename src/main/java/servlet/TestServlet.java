package servlet;

import dal.AbstractPortFactory;
import dal.PostgresqlAdapterFactory;
import dal.port.JudgePort;
import dal.port.PlayerPort;
import domain.Judge;
import domain.Player;
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

    private AbstractPortFactory factory  = new PostgresqlAdapterFactory();

    private JudgePort judgePort = factory.getJudgePort();

    private PlayerPort playerPort = factory.getPlayerPort();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        List<Player> players = playerPort.getAllPlayers();

        List<Judge> judges = judgePort.getAllJudges();

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
            for (Player player:players) {
                logger.info(player.getName());
                writer.print("<p>" + player.toString() + "</p>");
            }

            for (Judge judge:judges) {
                writer.print("<p>" + judge.toString() + "</p>");
            }

            writer.print("</body>");
            writer.print("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
