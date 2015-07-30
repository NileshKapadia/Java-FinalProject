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
    <body>
        
        
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
       
           
            <label for="caption">Caption:
                <input type="text" id="caption"></label></br>
            <label for="caption">Image:
                <input type="file" id="image" placeholder="Upload"></label><br>
                <input type="submit" name="submit" id="reg" value="Upload">
                <div id="photo"></div>
       
       <%
                        if (session.getAttribute("username") == null ) {
                    %>



                    <%
                    /*} else {
                      
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
                                String username = rs.getString("username");
                                String caption = rs.getString("caption");
                                out.println(username);
                                 out.println(caption);
                                 
                      Blob  b = rs.getBlob("photo");            
            response.setContentType("image/jpeg");
            response.setContentLength( (int) b.length());
           // response.setContentLength(10);
            InputStream is = b.getBinaryStream();
            OutputStream os = response.getOutputStream();
            byte buf[] = new byte[(int) b.length()];
            is.read(buf);
            
           os.write(buf);
            
                                
                            }
                        }
                       } */
                    %> 
      
    </body>
</html>
