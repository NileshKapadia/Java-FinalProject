/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NILESH
 */
@WebServlet(name = "sigup", urlPatterns = {"/sigup"})
public class sigup extends HttpServlet {
    
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrintWriter out = response.getWriter();
        
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String repeatpassword=request.getParameter("rpassword");
        
        out.println(username);
        out.println(password);
        out.println(repeatpassword);
   }
   

   
  
}
