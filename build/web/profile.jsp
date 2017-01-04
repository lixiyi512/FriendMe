<%@ page session="true" %>
<%@page import="Show.showProfile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="css/indexStyle.css" rel="stylesheet" type="text/css"/>
<link href="css/profile.css" rel="stylesheet" type="text/css"/>
<script src="js/main.js" type="text/javascript"></script>

<!--<script src="js/main.js" type="text/javascript"></script>-->
<%        
        if(username ==null){
        out.println("<script>alert('Please login/sign up to make friends!');</script>");
        out.println("<script>window.location.href = 'http://localhost:8080/FriendMe/index.jsp';</script>");
        }
%>

<!--    username = visitor/current user, username1 = visited user -->
<%
        
 String u1=request.getParameter("id");
  String username1="";
 if(u1=="")
          username1=(String)session.getAttribute("username");
 else if(u1!="")
      username1=u1;
%>


<div class="postForm">
    <form action="send_post?id1= <%=username%> &id2= <%=username1%>" method="POST">
    <textarea id="post" name="post" rows="5" cols="80"></textarea>
    <input type="submit" name="send"  value="Post" style="background-color: #DCE5EE; float: right; border: 1px solid #666; color:#666;height:73px; width: 65px;" />
    </form>
</div>

<div class="profilePosts">
    <div class="postList">
        <p>Message Board</p>
<!--       Display posts       -->
    <% 
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection conn = DriverManager.getConnection(connectionURL,"root","root");
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM posts where posted_to = '"+username1+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                out.println("<div class='posted_by'><a href=profile.jsp?id="+username+">"+username+"</a>"+" -- "+rs.getString("date")+" -- "+ rs.getString("post")+"</br></div><hr/>");
            }
        }
            catch(Exception ex){
                    out.println(ex);
                    }
        
        %>
</div>
<!-- testing purpose -->
<!--<div class="friendList">
    <%
    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection conn = DriverManager.getConnection(connectionURL,"root","root");
            Statement st = conn.createStatement();
            String q1 = new String("SELECT * FROM users where username ='"+username1 +"'");
            ResultSet rs =  st.executeQuery(q1);
            while(rs.next())
           {   
             out.println("<li>"+" <img src="+"'" + rs.getString("profile_pic")+"'height='50' width='45'" +"alt=''/>"+"<a href=profile.jsp?id="+rs.getString("username")+">"+rs.getString("username")+"</a>"+
                 "  "+rs.getString("first_name")+"</li>");
             out.println(username1);
           }
       }
       catch(Exception ex)
                 {
            out.println(ex);  
        }
    %>
</div>-->

</div>
<!--     Display profile picture    -->
<div class="profileimg">
    <%
    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection conn = DriverManager.getConnection(connectionURL,"root","root");
            Statement st = conn.createStatement();
            String q1 = "SELECT profile_pic FROM users where username =  '"+username1+"' ";
            ResultSet rs =  st.executeQuery(q1);
            while(rs.next())
           {  
             out.println(" <img src="+"'" + rs.getString("profile_pic")+"'height='250' width='200'" +"/>");
           }
       }
       catch(Exception ex)
                 {
            out.println(ex);  
        }
    %>
    

</div>
</br>   
   
<div class="textHeader"><%= username1 %>'s Bio</div>
<div class="profileLeftSideContent">
    
<!--    Display user's Bio    -->
  <% 
    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/friendme","root","root");
            Statement st2 = con.createStatement();
            String sql2 = "SELECT bio from users where username = '"+ username1 +"'";
            ResultSet rs2 = st2.executeQuery(sql2);
            while(rs2.next()){
                out.println("<p>"+rs2.getString("bio")+"</p>");
            }
        }catch(Exception ex){
            out.println(ex);
        }

    %>
    
</div>

    
    
    



























<%@ include file="footer.jsp"%>    