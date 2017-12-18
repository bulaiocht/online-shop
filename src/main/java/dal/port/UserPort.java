package dal.port;

import domain.QuizUser;

import java.util.List;

public interface UserPort {

    List<QuizUser> getAllUsers();

}