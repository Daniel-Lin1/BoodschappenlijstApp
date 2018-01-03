package dal.interfaces;
import java.util.List;

import models.User;

public interface UserContextJPA{
    boolean register(User newUser);
    boolean login(String username, String password);;
    List<User> getAllUsers();
    User getUser();
}
