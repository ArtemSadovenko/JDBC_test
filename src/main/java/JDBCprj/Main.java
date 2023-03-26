package JDBCprj;

//import com.mysql.fabric.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static String URL = "jdbc:mysql://localhost:3306/auto";
    public static String PASS = "root1111";
    public static String USER = "root";

    public static void main(String[] args) throws SQLException {
//        try{
//            DriverManager.getConnection(URL);
//        }catch (SQLException e){
//            System.out.println("Bad");
//        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            Connection con = DriverManager.getConnection(URL, PASS, USER);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
