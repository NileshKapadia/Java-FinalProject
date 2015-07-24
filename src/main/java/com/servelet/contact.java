/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import databaseCredential.databaseconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NILESH
 */
@WebServlet(name = "contact", urlPatterns = {"/contact"})
public class contact extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name1 = request.getParameter("name");
        String email1 = request.getParameter("email");
         String website1 = request.getParameter("website");
          String message1 = request.getParameter("message");
        

          
        PrintWriter pt = response.getWriter();
        pt.println(website1);
        pt.println(name1);

       

        Connection conn = databaseconnection.getConnection();
        if(conn != null)
        {
            pt.println("connection success");
        }
        Statement stmt;
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO contact(name, email, website,message) "
                   + "VALUES ('" + name1 + "', '" + email1+ "','" + website1 + "','" + message1+ "')";
            ResultSet rs = stmt.executeQuery(sql);
            response.sendRedirect("jsp/contact.jsp");
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
   }           

}
