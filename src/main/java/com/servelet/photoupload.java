/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import databaseCredential.databaseconnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author NILESH
 */
@WebServlet(name = "photoupload", urlPatterns = {"/photoupload"})
public class photoupload extends HttpServlet {
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrintWriter pt = response.getWriter();
        String image = null;
        String caption = null;
        
        String uploadimage=request.getParameter(image);
        
        String caption1=request.getParameter(caption);
        
        pt.println(uploadimage);
        pt.println(caption1);
        
        
        InputStream inputStream = null; // input stream of the upload file
        
      
       Part filePart = request.getPart("image");
       if (filePart != null) {
           
            pt.println(filePart.getName());
           pt.println(filePart.getSize());
           pt.println(filePart.getContentType());
            
           
           inputStream = filePart.getInputStream();
       }
       
       
        // connection to the database
       String message = null;  // message will be sent back to client
        
       try {
           // connects to the database
           
             Connection conn = databaseconnection.getConnection();

           // constructs SQL statement
           String sql = "INSERT INTO photoupload (username, photo, caption) values (?, ?, ?)";
           PreparedStatement statement = conn.prepareStatement(sql);
           //statement.setString(1, username);
           
            
//                File image = new File(image1);
//                FileInputStream   fis = new FileInputStream(image.getAbsolutePath());
//                statement.setBinaryStream(2, fis, (int) image.length());
//                statement.execute();
            if (inputStream != null) {
              
             statement.setBlob(2, inputStream);
           }
           statement.setString(3, caption);
           

           // sends the statement to the database server
          int row = statement.executeUpdate();
           
           if (row > 0) {
              
               HttpSession  success_ad = request.getSession(true);
               success_ad.setAttribute("success_message","Your Photo is posted successfully!");
               response.sendRedirect("jsp/Success.jsp");
          }
                
        
    }   catch (SQLException ex) {
            Logger.getLogger(photoupload.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
}

  


