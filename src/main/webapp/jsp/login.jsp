<%-- 
    Document   : login
    Created on : Jul 23, 2015, 7:09:55 PM
    Author     : NILESH
--%>

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
    </head>
    <body>
        
        
        <div class="main">
  <div class="main_resize">
    <div class="header">
      <div class="logo">
        <h1><a href="#"><span>Photo</span>Liaise<small>Simple web template</small></a></h1>
      </div>
      <div class="search">
        <form method="get" id="search" action="#">
          <span>
          <input type="text" value="Search..." name="s" id="s" />
          
          </span>
        </form>
        <!--/searchform -->
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.html">Home</a></li>
          <li><a href="support.html">Support</a></li>
          <li><a href="about.html">About Us</a></li>
          <li><a href="blog.html">Contact Us</a></li>
          <li><a href="login.html">Login</a></li>
		  <li><a href="">Sign Up</a></li>
        </ul>
        <div class="clr"></div>
      </div>
      </div>
      </div>
       </div>
        <form action="photoupload" method="get">
            <label for="caption">Caption 
             <input type="text" name="caption" value="caption"></label>
        <input type="file" name="image" placeholder="Upload">
        </form>
      
    </body>
</html>
