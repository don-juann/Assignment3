import java.sql.Connection;
import java.sql.DriverManager;

public class DBMethods {
    public Connection connect_to_DB(String DBName, String Username, String password ){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/"+DBName,
                            Username, password);
            if(connection!=null){
                System.out.println("Connection established");
            }else{
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
