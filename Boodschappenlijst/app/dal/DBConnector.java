package dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    Connection conn = null;
    String conString =
            "jdbc:mysql://studmysql01.fhict.local:3306/dbi347692";

    public void connect() {
        try
        {
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection (conString,"dbi347692","hallo123");
            System.out.println ("Database connection established");
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
    }
}
