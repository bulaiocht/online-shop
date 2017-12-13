import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kocherha Vitalii on 05.12.2017.
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet{

    private final static Logger logger = Logger.getLogger(TestServlet.class);

    @Resource(name = "jdbc/ec2")
    private DataSource postgresDataSource;

    @Resource(name = "jdbc/world")
    private DataSource mysqlDatasource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> tableData = new ArrayList<>();

        try{
            connection = postgresDataSource.getConnection();
            String sql = "SELECT * FROM role";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                tableData.add(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            connection = mysqlDatasource.getConnection();
            String sql = "SELECT * FROM country";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                tableData.add(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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
        for (String data : tableData){
            writer.print("<p>" + data + "</p>");
        }
        writer.print("</h1>");
        writer.print("</body>");
        writer.print("</html>");
    }
}
