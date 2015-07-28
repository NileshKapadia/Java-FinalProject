/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import databaseCredential.databaseconnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author NILESH
 */
@WebServlet(name = "photoupload", urlPatterns = {"/photoupload"})
@MultipartConfig(maxFileSize = 16177215)
public class photoupload extends HttpServlet {
    private Object Json;
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrintWriter pt = response.getWriter();
        
        
        //String uploadimage=request.getParameter("image");
        
        String caption1=request.getParameter("caption");
         
               HttpSession session = request.getSession();
        String userid =(String) session.getAttribute("username");
      
        
       // pt.println(uploadimage);
       // pt.println(caption1);
         //pt.println(userid);
        
        
        InputStream inputStream = null; // input stream of the upload file
        
      
       Part filePart = request.getPart("image");
       if (filePart != null) {
           
           // pt.println(filePart.getName());
          // pt.println(filePart.getSize());
          // pt.println(filePart.getContentType());
            
           
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
           statement.setString(1, userid);
           
            
            if (inputStream != null) {
              
             statement.setBlob(2, inputStream);
           }
           statement.setString(3, caption1);
           

           // sends the statement to the database server
          int row = statement.executeUpdate();
          
          
          
           String imagequery = "SELECT image from photoupload";

           statement = (PreparedStatement) conn.createStatement();
           ResultSet rs = statement.executeQuery(imagequery);
            int count = 0;
            int a1= 0;
            String base64String="";
            

           while (rs.next()) {
               count++;

               InputStream stream = rs.getBinaryStream(1);
               ByteArrayOutputStream output = new ByteArrayOutputStream();

               try {
                   a1 = stream.read();
               } catch (IOException ex) {
               }
               while (a1 >= 0) {
                   output.write((char) a1);
                   try {
                       a1 = stream.read();
                   } catch (IOException ex) {

                   }
               }
               byte[] dt = new byte[166666];
               base64String = DatatypeConverter.printBase64Binary(output.toByteArray());
                pt.write(base64String);
                   
           }
       
          
       } catch (SQLException ex) {
           String msg = ex.getMessage();

       } 

    
          
          
          
         /* String sql1 = "select * from photoupload";
            ResultSet rs = statement.executeQuery(sql1);
           String username=null;
            String caption2=null;
             String image=null;
           while (rs.next()) {
                username = rs.getString("username");
                caption2 = rs.getString("caption");
                image = rs.getString("image");
                
                pt.println(username);
                   pt.println(caption2);

            }*/
           
           
           
               //response.sendRedirect("jsp/Success.jsp");
          }

           
           
 }

    
    


  

