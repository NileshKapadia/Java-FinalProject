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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
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
    
    
JsonArrayBuilder array = Json.createArrayBuilder();
   
    
    
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    
response.setHeader("Cache-control", "no-cache, no-store");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "-1");
        try {
            PrintWriter pt = response.getWriter();
            String imagequery = "SELECT photo from photoupload";
            
            Connection conn = databaseconnection.getConnection();
            Statement statement = conn.createStatement();
            
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
                pt.write("in stream problem");
                }
                while (a1 >= 0) {
                    output.write((char) a1);
                    try {
                        a1 = stream.read();
                    } catch (IOException ex) {
                     pt.write("cant write array");
                    }
                }
                byte[] dt = new byte[166666];
                base64String = DatatypeConverter.printBase64Binary(output.toByteArray());
               HttpSession session=request.getSession();
               String base4String =(String) session.getAttribute("base64String");
               
               
                pt.write(base64String);
                
                 if (count == 0) 
                 {
              
                    base64String = "images/icon.png";
                    
              JsonObjectBuilder build = Json.createObjectBuilder().add("image", base64String);

                 array.add(build);
               
               //return "did not read image from data base";

           }

       
               // pt.write("rfhrfjtykhjfjyukjtyjgjk,uimhgjgykutju");
            }
            
            String img = array.build().toString();
            
            
            pt.write(img);
        } catch (SQLException ex) {
                        PrintWriter pt = response.getWriter();

            pt.write("in cache get");
            //.getLogger(photoupload.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
          
       } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
response.setHeader("Cache-control", "no-cache, no-store");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "-1");
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
          
          
          
          } catch (SQLException ex) {
              //pt.write("post cache");
            Logger.getLogger(photoupload.class.getName()).log(Level.SEVERE, null, ex);
        }

           
           
 }

    private void add(JsonObjectBuilder build) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
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
          
    
    



    
    


  

