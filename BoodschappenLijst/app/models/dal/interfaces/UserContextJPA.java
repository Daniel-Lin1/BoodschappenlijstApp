package models.dal.interfaces;

import models.User;

public interface UserContextJPA {
    public boolean login(String username, String password);
    public boolean register(User newuser);

}
