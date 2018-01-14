package models;

import org.hibernate.annotations.GenericGenerator;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.getAll", query = "select u from User as u"),
        @NamedQuery(name = "User.login", query = "select u from User as u where u.username = :username and u.password = : password")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Constraints.Required
    private long id;

    @Column(name = "username")
    @Constraints.Required
    private String username;

    @Column(name = "email")
    @Constraints.Required
    private String email;

    @Column(name = "password")
    @Constraints.Required
    private String password;



    private ArrayList<String> recipeList;
    // TODO:
    // Find some way to store this kind of relation in DB

    public User() {

    }

    public User(String username, String email, String password, ArrayList<String> recipeList){
        this.username = username;
        this.email = email;
        this.password = password;
        this.recipeList = recipeList;
    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(ArrayList<String> recipeList) {
        this.recipeList = recipeList;
    }



}
