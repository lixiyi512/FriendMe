
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <title>Friend Me</title>
    </head>
    <body>
        <div class="headerMenu">
            <div id="wrapper">
                <% 
                    String username = (String)request.getSession().getAttribute("username");
                if(username != null){
                        out.println("<div class='menu'>");
                        out.println("<a href='home.jsp'>Home</a>");
                        out.println("<a href='profile.jsp?id="+username+"'>"+username+"'s Profile</a>");
                        out.println("<a href='setting.jsp'>Setting</a>");
                        out.println("<a href='http://localhost:8080/FriendMe/LogOut'>Log Out</a>");
                        out.println("</div>");
                    
                }
                    
                    %>
                
                <div class="logo">
                    <img src="img/logo.png"/>
                </div>                
            </div>
        </div>
                    <div id="wrapperMain">
        
<!--        <div class="footer">
           Copyright &copy;  Xiyi Li. All rights reserved.
        </div>
    </body>
</html>-->
