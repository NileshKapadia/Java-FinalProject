/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
       
                
        
    }

    
    }

  


