<%-- 
    Document   : login
    Created on : Jul 23, 2015, 7:09:55 PM
    Author     : NILESH
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.PrintWriter"%>
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
        <link href="../style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/cufon-yui.js"></script>
<script type="text/javascript" src="../js/arial.js"></script>
<script type="text/javascript" src="../js/cuf_run.js"></script>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="../js/profilepage.js"></script>


    </head>
    
        
        
        <div class="main">  
  <div class="main_resize">
    <div class="header">
      <div class="logo">
        <h1><a href="#"><span>Photo</span>Liase<small>Simple website</small></a></h1>
      </div>
      <div class="search">
        
       
        <!--/searchform -->
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="../index.html">Home</a></li>
         
          <li><a href="../about.html">About Us</a></li>
          <li><a href="../blog.html">Contact Us</a></li>
          <li><a href="../newhtml.html">Login</a></li>
		 
        </ul>
        <div class="clr"></div>
      </div>
      </div>
      </div>
       </div>
       
        <div class="photoupload">
            <form action="/photoupload" method="post" enctype="multipart/form-data">
            <label for="caption">Caption:
                <input type="text" id="caption" name="caption"></label></br>
            <label for="caption">Image:
                <input type="file" id="image" placeholder="Upload" name="image"></label><br>
                <input type="submit" name="submit" value="Upload">
            </form>
        </div>
                <!--<div id="photo">
                    
                    
                    <form action="comment" method="post">
                    <input type="text" name="comment" id="comment">
                    <input type="submit" value="Post">
                    </form>
                    
                </div>-->
       
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
                            String query = "select * from photoupload ";
                           
                         
                            ResultSet rs = smt.executeQuery(query);
                            
                          
                            
                            
                            
                            while (rs.next()) {
                                 String img_id = rs.getString("img_id");
                                String username = rs.getString("username");
                                String caption = rs.getString("caption");
                       // out.println(img_id);
                               // out.println(username);
                                 //out.println(caption);
                                 
  
            
                      %> 
                       <br><br><br>
                    <table>
                        
                            
                        <tr> <td><%=caption%></td></tr>
                        <tr><td id="imagetd" rowspan="7"><img src="../image.jsp?id=<%=img_id%>" width="200" height="200"/><td> </tr>
                        
                        <form action="/comment" method="get">
                            <table>
                            <tr><td><input type="text" name="comment" id="comment"></td></tr>
                            <tr>  <td> <input type="submit" value="Comment"></td></tr>
                            </table
                        </form>
                      
                   
                    
                    
                </div>
                       
                    </table>

                    <%
                           
                           
                            }
                        }
                       } 
                    %> 
                    
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
                           
                             
                            }
                            
                        }
                       
                       } 
                    %> 
      
      
    
</html>
