

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="css/indexStyle.css" rel="stylesheet" type="text/css"/>
<link href="css/home.css" rel="stylesheet" type="text/css"/>
<%        
        if(username ==null){
        out.println("<script>alert('Please login/sign up to make friends!');</script>");
        out.println("<script>window.location.href = 'http://localhost:8080/FriendMe/index.jsp';</script>");
        }
        else{
            
        }
%>
<div class="home">
<div class="newsfeed">
    
    <img src="./img/makefriend.jpg" width="798" alt=""/>
    <h2>  <i style="font-size: 18px">Hi,<%= username %>!</i>  Welcome to FINDFRIENDS:) </h2>
    <%= username %>
</div>
<% 
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection conn = DriverManager.getConnection(connectionURL,"root","root");
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM posts where posted_to = 'tommy'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                out.println(rs.getString("post")+rs.getString("posted_by"));
            }
        }
            catch(Exception ex){
                    out.println(ex);
                    }
        
        %>
<div class="friendList">
    <h1>Below are the users, you can go to their profile page and get to know them by clicking their nick name </h1>
    <%
    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection conn = DriverManager.getConnection(connectionURL,"root","root");
            Statement st = conn.createStatement();
            String q1 = new String("SELECT username,first_name,profile_pic FROM users");
            ResultSet rs =  st.executeQuery(q1);
           
            while(rs.next())
           {   
             out.println("<div class='userdisplay'>"+" <center><a href=profile.jsp?id="+rs.getString("username")+"><img src="+"'" + rs.getString("profile_pic")+"'height='50' width='45' " +"alt=''/></a></center>"+"<p><a href=profile.jsp?id="+rs.getString("username")+">"+rs.getString("username")+"</a>"+
                 "<p></div>");
           }
       }
       catch(Exception ex)
                 {
            out.println(ex);  
        }
    %>
</div>
<div class="searchDisplay">
<div class="search">
    <p>Type the username/first name or last name of the person you are looking for.</p>
                    <form action="SearchUser" method="GET" id="search">
                        <input type="text" name="search" size="10" placeholder="type ...">
                        
                         <input type="submit" id="searchSubmit" value="search" />
                    </form>
     </div>
    <img src="./img/friend.jpg" alt="" width="340"/>        
</div>
</div>






















<%@ include file="footer.jsp"%>     
