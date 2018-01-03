package dal.repositories;

import dal.contexts.UserContext;
import dal.interfaces.UserContextJPA;

public class UserRepo{

    private UserContextJPA userContext;

    public UserRepo(UserContextJPA userContext){
        this.userContext = userContext;
    }

    public boolean login(String username, String password) {
        return userContext.login(username, password);
    }
}
