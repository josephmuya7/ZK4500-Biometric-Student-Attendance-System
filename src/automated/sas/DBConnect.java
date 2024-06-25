
package automated.sas;

/**
 *
 * @author Smoker
 */

import java.sql.DriverManager;

public class DBConnect {
    
    static final String C_URL = "jdbc:mysql://localhost:3306/Asas";
    static final String USER = "root";
    static final String PASS = "";
    public static java.sql.Connection connect()
    {
        java.sql.Connection con = null;
        try
        {
            //register jdbc driver ,not required for newer versions of jdk
           // Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(C_URL,USER,PASS);
            return con;
        }catch(Exception ex)
        {
            System.out.println("inter.DBConnect.connect()");
            return null;
        }
    }
    
}
