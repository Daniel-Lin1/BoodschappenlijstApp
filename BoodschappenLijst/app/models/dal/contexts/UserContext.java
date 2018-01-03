package models.dal.contexts;

import models.User;
import models.dal.interfaces.UserContextJPA;

public class UserContext implements UserContextJPA {

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean register(User newuser) {
        return false;
    }
}
