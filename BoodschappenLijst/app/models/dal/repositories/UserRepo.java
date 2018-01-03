package models.dal.repositories;

import models.User;
import models.dal.contexts.UserContext;

public class UserRepo {
    private UserContext userContextt;

    public UserRepo(UserContext userContext){
        this.userContextt = userContext;
    }

    public boolean login(String username, String password){
        return userContextt.login(username, password);
    }

    public boolean register(User newUser){
        return userContextt.register(newUser);
    }
}
