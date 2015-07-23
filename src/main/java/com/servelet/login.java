/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import databaseCredential.databaseconnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NILESH
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter pt = response.getWriter();

        pt.println(username);
        pt.println(password);

        Connection conn = databaseconnection.getConnection();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            String id = null;
            String pass = null;

            String sql = "SELECT * FROM login where username='" + username + "' and password='" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString("username");
                 pass = rs.getString("password");

            }
            if (id != null && pass != null) {
                pt.println("Login Sucess ");
                HttpSession success = request.getSession(true);
                success.setAttribute("name", id);
                response.sendRedirect("jsp/login.jsp");
            } else {

                pt.println("Login failed");
                HttpSession fail = request.getSession(true);
                fail.setAttribute("error", "Please enter valid username and passwod");
                response.sendRedirect("jsp/acount.jsp");

            }

        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* if(conn==null)
         {
         pt.println("connection failed");
         }
         else
         {
         pt.println("connection success");
         }*/
    }

}
