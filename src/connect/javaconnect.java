    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Andreja
 */
public class javaconnect {
    Connection conn = null;
    private Statement pst;
    ResultSet rs;
    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orgstruktura","root","");
              return conn;
        }catch(Exception e){
            System.out.println("Greska" +e);
           
        }
        return null;
    }
}
