package dal.repositories;

import dal.contexts.UserContext;
import dal.interfaces.UserContextJPA;
import models.User;

public class UserRepo{

    private UserContextJPA userContext;

    public UserRepo(UserContextJPA userContext){
        this.userContext = userContext;
    }

    public boolean login(String username, String password) {
        return userContext.login(username, password);
    }

    public boolean register(User newUser){return userContext.register(newUser);}

    public User getUser(String user) { return null;}
}
