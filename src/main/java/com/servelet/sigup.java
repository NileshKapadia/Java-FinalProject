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
@WebServlet(name = "sigup", urlPatterns = {"/sigup"})
public class sigup extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pt = response.getWriter();

        String username = request.getParameter("email");
        String password = request.getParameter("password");

        String sex = request.getParameter("gender");
        String age = request.getParameter("age");
        String username1 = request.getParameter("username1");
        int age1 = Integer.parseInt(age);
        
          HttpSession  session = request.getSession();
        session.setAttribute("username1", username1);

        pt.println(username);
        pt.println(password);
        pt.println(sex);
        pt.println(age1);

        Connection conn = databaseconnection.getConnection();
        Statement smt;
        try {
            smt = conn.createStatement();

            String sql = "INSERT INTO login (username,username1,password , gender , age) "
                    + "VALUES ('" + username + "', '" + username1 + "','" + password + "','" + sex + "','" + age1 + "')";

            smt.executeUpdate(sql);
            pt.println("ddddddddddddddddddddddddd");
            response.sendRedirect("jsp/login.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(sigup.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
