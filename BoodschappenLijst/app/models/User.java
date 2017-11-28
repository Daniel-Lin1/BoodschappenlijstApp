package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class User {

@Id @GeneratedValue
    private long id;
    private String userName, email, password;
    private ArrayList<String>recipeList;


    public  User(String userName, String email, String password, ArrayList<String> recipeList){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.recipeList = recipeList;
    }

}
