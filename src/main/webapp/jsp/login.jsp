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
    <div id="photoset">
      
        <%
            if (session.getAttribute("username") == null) {
        %>



        <%
        } else {

            Connection conn = databaseconnection.getConnection();
        //  PrintWriter out = response.getWriter();

            if (conn == null) {
                out.println("success");
            } else {

                Statement smt = conn.createStatement();
                String query = "select * from photoupload ";

                ResultSet rs = smt.executeQuery(query);

                while (rs.next()) {
                    String img_id = rs.getString("img_id");
                    String username = rs.getString("username");
                    String caption = rs.getString("caption");
                    


        %> 
        <br><br><br>
        <div id="photoset">
            <table>


                <tr> <td><h2>Posted By::<%=username%></h2></td></tr>
                <tr> <td><h3><%=caption%></h3></td></tr>
                <tr><td id="imagetd" rowspan="7"><img src="../image.jsp?id=<%=img_id%>" width="250" height="250"/><td> </tr>

                <%

                    Statement smt1 = conn.createStatement();
                    String query1 = "select * from comment where img_id='" + img_id + "'";
                   
                   

                    ResultSet rs1 = smt1.executeQuery(query1);
                    while (rs1.next()) {

                        String comment1 = rs1.getString("comment");
                %>

                <tr><td><h2><%=comment1%></h2></td></tr>
                <%
                    }


                %> 





                <form action="/comment" method="get">
                    <table>
                        <input type="hidden" name="image_id" value="<%=img_id%>">
                        <tr><td><input type="text" name="comment" value=""></td></tr>
                        <tr>  <td> <input type="submit" value="Comment"></td></tr>
                        
                    </table>
                </form>

                    </div>
                    <div id="photoset">
                        <script type="text/javascript">
                            var clicks = 10;
                            function onClick() {
                                clicks += 1;
                                document.getElementById("clicks").innerHTML = clicks;
                            }
                            ;
                        </script>
                        <button type="button" onClick="onClick()">Like</button>
                        <p>Likes: <a id="clicks">10</a></p>




                    </div>



                    <%

                                }
                            }
                        }
                    %> 


    </body>

                    </html>
