/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecb_java;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author stefan
 */
public class WriteValues extends ReadValues{
    
final static String HOSTNAME = "localhost";
final static String PORT = "3306";
final static String USER = "root";
final static String PWD = "";
final static String DBNAME = "test_db";

public java.sql.Connection setupConnection() {

    java.sql.Connection conn = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
    }

  //  System.out.println("Connection is being established...");
    String url = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DBNAME +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    
    try {
        conn = DriverManager.getConnection(url, USER, PWD);
    } catch (SQLException e) {
    }

    //System.out.println("Database connection successfully established!");

    return conn;
}

 public void insert(String s, String t, String u){

        Connection conn;
        conn = setupConnection();
        try{
            String query = "insert into currency values (null, '"+s+"', '"+t+"', '"+u+"')";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);


      // execute the preparedstatement
      preparedStmt.execute();
 //     JOptionPane.showMessageDialog(null, "Data added");

        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
