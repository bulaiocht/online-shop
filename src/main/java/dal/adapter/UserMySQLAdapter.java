package dal.adapter;

import dal.connect.ConnectionSupplier;
import dal.port.UserPort;
import domain.QuizUser;
import domain.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMySQLAdapter implements UserPort {

    private static final Logger logger = LogManager.getLogger(UserMySQLAdapter.class);

    private ConnectionSupplier connectionSupplier;

    private static final String GET_BY_USERNAME = "SELECT role.role_name, user.user_id, user.username, user.password FROM role JOIN user ON user.role_id=role.role_id WHERE user.username=?";
    private static final String FIND_EXACT = "SELECT role.role_name, user.user_id, user.username, user.password" +
            " FROM role JOIN user ON user.role_id=role.role_id" +
            " WHERE user.username=? AND user.password=?";

    private static final String SELECT_ALL = "SELECT * FROM user JOIN role ON user.role_id=role.role_id";

    public UserMySQLAdapter(ConnectionSupplier connectionSupplier) {
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
                    user.setRole(Role.valueOf(resultSet.getString("role_name")));
                    quizUsers.add(user);
                }
            }
        } catch (SQLException e) {
            logger.fatal("SQL exception happened!", e);
        }
        return quizUsers;
    }

    @Override
    public QuizUser findByUsername(String username) {
        QuizUser user = null;
        try(Connection conn = connectionSupplier.getConnection()){
            if (conn!=null){
                logger.info("Connection obtained");
                PreparedStatement statement = conn.prepareStatement(GET_BY_USERNAME);
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    user = new QuizUser();
                    user.setId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setHexPassword(resultSet.getString("password"));
                    user.setRole(Role.valueOf(resultSet.getString("role_name")));
                }
            }
        } catch (SQLException e) {
            logger.fatal("SQL exception happened!", e);
        }
        return user;
    }

    @Override
    public boolean isPresent(QuizUser user){
        findByUsername(user.getUsername());
        return false;
    }

    @Override
    public boolean save(QuizUser user) {
        return false;
    }

    @Override
    public QuizUser delete(QuizUser user) {
        return null;
    }
}
