/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import com.google.gson.Gson;
import databaseCredential.databaseconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NILESH
 */
@WebServlet(name = "uploadsuccess", urlPatterns = {"/uploadsuccess"})
public class uploadsuccess extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet uploadsuccess</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet uploadsuccess at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         PrintWriter out = response.getWriter();

        //out.write("exception coccure123");
        // JsonObjectBuilder json = Json.createObjectBuilder();
        //JsonArrayBuilder productarray = Json.createArrayBuilder();
        
        user p = new user();
        ArrayList<user> users= new ArrayList<user>();
        
        
        Connection conn = databaseconnection.getConnection();

        if (conn == null) {
            out.println("null");
        } else {

            out.println("not null");
        }

        try {
            Statement smt = conn.createStatement();

            ResultSet rs = smt.executeQuery("select * from photoupload");

            while (rs.next()) {

                user  pnew = new user(rs.getString(1),rs.getString(2), rs.getString(3));
                users.add(pnew);
                out.println(rs.getString(1));
                out.println(rs.getString(2));
                out.println(rs.getString(3));
                 
            }
            String json = new Gson().toJson(users);
            out.print(json);

        }  catch (SQLException ex) {
            Logger.getLogger(uploadsuccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
