<%-- 
    Document   : comment
    Created on : Aug 1, 2015, 5:53:06 PM
    Author     : NILESH
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="databaseCredential.databaseconnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
         <%
                        if (session.getAttribute("username") == null ) {
                    %>



                    <%
                    } else {
                      
                    Connection conn=databaseconnection.getConnection();
                    //  PrintWriter out = response.getWriter();
                     
                        if (conn == null) {
                            out.println("success");
                        }
                        
                         else 
                        {
                           
                            Statement smt = conn.createStatement();
                            
                             String query2 = "select * from comment ";
                             ResultSet rs = smt.executeQuery(query2);
                            
                          
                            
                            
                            
                            while (rs.next()) {
                                  
                            String comments = rs.getString("comment");
                            out.println(comments);
                                 
  
            
                      %> 
                       <br><br><br><br>
                       <table>
                        
                            
                        <tr> <td><%=comments%></td></tr>
                        
                </table>

                    <%
                           
                             response.sendRedirect("jsp/login.jsp");
                            }
                        }
                       
                       } 
                    %> 
      
    </body>
</html>
