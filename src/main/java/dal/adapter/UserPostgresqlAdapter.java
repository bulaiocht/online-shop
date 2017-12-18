package dal.adapter;

import dal.connect.ConnectionSupplier;
import dal.port.UserPort;
import domain.QuizUser;
import domain.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserPostgresqlAdapter implements UserPort {

    private static final Logger logger = LogManager.getLogger(UserPostgresqlAdapter.class);

    private ConnectionSupplier connectionSupplier;

    private static final String SELECT_ALL = "SELECT * FROM user";

    public UserPostgresqlAdapter(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public List<QuizUser> getAllUsers() {
        List<QuizUser> quizUsers = new ArrayList<>();
        try(Connection conn = connectionSupplier.getConnection()){
            if (conn!=null){
                logger.info("Connection obtained");
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL);
                while (resultSet.next()){
                    QuizUser user = new QuizUser();
                    user.setId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setRole(Role.getById(resultSet.getInt("role_id")));
                    quizUsers.add(user);
                }
            }
        } catch (SQLException e) {
            logger.fatal("Failed to get connection!", e.getCause());
        }
        return quizUsers;
    }
}
