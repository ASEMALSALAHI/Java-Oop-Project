/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maassystemoop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;


import java.sql.SQLException;

/**
 *
 * @author user1
 */
public class ElemanDb {
     static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/maassystem";
    static String uname = "root";
    static String pass = "admin";
  
    
    public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url,uname, pass);
        }
        return con;
    
}
}
