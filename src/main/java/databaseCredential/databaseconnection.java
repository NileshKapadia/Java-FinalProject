/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseCredential;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NILESH
 */
@WebServlet(name = "databaseconnection", urlPatterns = {"/databaseconnection"})

    
    
public class databaseconnection {
   
  
      public static Connection getConnection() {
       Connection conn = null;
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           System.err.println("JDBC Driver Not Found: " + ex.getMessage());
       }

       try {
           String jdbc = "jdbc:mysql://127.11.113:3306/photoliaisespaczer";
           conn = (Connection) DriverManager.getConnection(jdbc, "adminYHfd3Q3", "jBG7NIjkdagK");
       } catch (SQLException ex) {
           System.err.println("Failed to Connect: " + ex.getMessage());
       }
       return conn;
   }
}

 

   
  

   
    

