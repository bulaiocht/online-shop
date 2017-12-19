package dal.adapter;

import dal.connect.ConnectionSupplier;
import dal.port.UserPort;
import domain.QuizUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserPostgresqlAdapter implements UserPort {

    private static final Logger logger = LogManager.getLogger(UserPostgresqlAdapter.class);
    private static final String GET_BY_USERNAME = "SELECT * FROM user WHERE username=?";

    private ConnectionSupplier connectionSupplier;

    private static final String SELECT_ALL = "SELECT * FROM user";

    public UserPostgresqlAdapter(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    /**
     * STUB method
     * @return empty {@link ArrayList} object
     */
    @Override
    public List<QuizUser> getAllUsers() {
        return new ArrayList<>();
    }

    /**
     * STUB method
     * @param username username
     * @return empty {@link QuizUser} object
     */
    @Override
    public QuizUser findByUsername(String username) {
        return new QuizUser();

    }

    /**
     * STUB method
     * @param user user
     * @return {@code false}
     */
    @Override
    public boolean isPresent(QuizUser user) {
        return false;
    }

    /**
     * STUB method
     * @param user user
     * @return {@code false}
     */
    @Override
    public boolean save(QuizUser user) {
        return false;
    }

    /**
     * STUB method
     * @param user user
     * @return empty {@link QuizUser} object
     */
    @Override
    public QuizUser delete(QuizUser user) {
        return new QuizUser();
    }
}