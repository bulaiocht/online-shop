package dal.port;

import domain.QuizUser;

import java.util.List;

public interface UserPort {

    List<QuizUser> getAllUsers();

    QuizUser findByUsername(String username);

    boolean isPresent(QuizUser user);

    boolean save(QuizUser user);

    QuizUser delete(QuizUser user);

}