import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class User {

@Id @GeneratedValue
    private long id;
    private String userName;
    private ArrayList<String>Recipelist;


    public  User(String userName){
        this.userName = userName;
    }

}
