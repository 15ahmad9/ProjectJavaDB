package ProjectJavaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author AhmadGhanem
 */
public class Student {

    public static void main(String[] args) throws SQLException {
        try {
            String host = "jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String uName = "root";
            String uPass = "1789";
            
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement();  // انشاء ستيتمنت
            String SQL = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) //يرجع بيانات في الجدول
            {
            int ID = rs.getInt("ID");
            String FirstName = rs.getString("FirstName");
            String LastName = rs.getString("LastName");
            String Major = rs.getString("Major");
            double Average = rs.getDouble("Average");
            System.out.println(ID + " " + FirstName + " " + LastName + " " + Major + " " + Average);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
