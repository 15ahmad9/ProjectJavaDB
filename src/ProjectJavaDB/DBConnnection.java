
package ProjectJavaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class DBConnnection {

    private static DBConnnection dbcon ;
    String host = "jdbc:mysql://localhost:3306/college?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String uName = "root";
    String uPass = "1789";
    Connection con;
    Statement stmt;
    String SQL;
    ResultSet rs;

    private DBConnnection() {
        try {

            System.out.println("hi");
            con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement();
           
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static DBConnnection getCon() {
        if(dbcon == null){
            dbcon = new DBConnnection();
        }
        return dbcon;
    }
    public ResultSet runQ(String s) throws SQLException{
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(s);
        return rs;
    }

}
