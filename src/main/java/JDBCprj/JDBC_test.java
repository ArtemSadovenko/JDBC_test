package JDBCprj;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class JDBC_test {
    private static String url = "jdbc:mysql://localhost/auto";
    private static String user = "root";
    private static String password = "root1111";

    public static void main(String[] args) {
        selectAll();
        insert("Audi qatro X5");
        selectAll();
    }

    public static void insert(String name) {
        try {

            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO car (name_car) VALUES (?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "matis");

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectAll() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * from car";

            Statement prst = conn.createStatement();

            ResultSet set = prst.executeQuery(sql);
            Map<Long, String> res = new HashMap<>();

            while (set.next()) {
                long id = set.getInt("id");
                String name_car = set.getString("name_car");

                res.put(id, name_car);
            }
            System.out.println(res);

            prst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
