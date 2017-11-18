package DB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class ManagementSystem {
    private static Connection con;
    private static ManagementSystem instance;

    private ManagementSystem() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/atschool";
            con = DriverManager.getConnection(url, "root", "Maledima256");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static ManagementSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ManagementSystem();
        }
        return instance;
    }

    public String[][] getPeople(String role) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String[][] result;
        try {
            stmt = con.prepareStatement("Select login, password FROM peoples WHERE role=?");
            stmt.setString(1, role);
            rs = stmt.executeQuery();
            rs.last();
            result = new String[rs.getRow()][2];
            rs.beforeFirst();
            int row;
            while (rs.next()) {
                row = rs.getRow()-1;
                result[row][0] = rs.getString("login");
                result[row][1] = rs.getString("password");
            }
           }
         finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
               stmt.close();
            }
        }
        return result;
    }

    public void printPeople(String[][] people){
        for (int i=0;i<people.length;i++){
            System.out.println(Arrays.toString(people[i]));
        }
    }


}
