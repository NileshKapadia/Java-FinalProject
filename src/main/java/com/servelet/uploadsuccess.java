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
    }
}

        
        
       

    
  


