

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@page import="Show.showProfile"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<link href="css/indexStyle.css" rel="stylesheet" type="text/css"/>
<link href="css/setting.css" rel="stylesheet" type="text/css"/>

<%        
        if(username ==null){
        out.println("<script>alert('Please login/sign up to make friends!');</script>");
        out.println("<script>window.location.href = 'http://localhost:8080/FriendMe/index.jsp';</script>");
        }
%>



<h2>Edit your Account Settings below</h2>
<hr />
<div class="left">
<p>UPLOAD YOUR PROFILE PHOTO:</p>

<!--        Display user's profile picture-->
<form action="" method="POST" enctype="multipart/form-data">
    <%

    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection conn = DriverManager.getConnection(connectionURL,"root","root");
            Statement st = conn.createStatement();
            String q1 = "SELECT profile_pic FROM users where username =  '"+username+"' ";;
            ResultSet rs =  st.executeQuery(q1);
            while(rs.next())
           {  
             out.println(" <img src="+"'" + rs.getString("profile_pic")+"'height='265' width='230'" +"/>");
           }
       }
       catch(Exception ex)
                 {
            out.println(ex);  
        }
   
        %>
<input type="file" name="profilepic" style="padding-left: 28px; padding-bottom: 15px; padding-top: 20px;" /><br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="uploadpic" value="Upload Image"  >
</form>
<!--<h2>FILE UPLOAD PART Haven't accomplished yet :/</h2>-->
</div>
<div class="right">
    <div class="up">
        
<!--   Display personal informaion and allow user to edit.     -->
<%  
    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/friendme","root","root");
            Statement st = con.createStatement();
            String sql = "SELECT first_name,last_name,bio from users where username = ('"+ username+"')";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
  %>               
        <form action="UpdateProfileInfo" method="post">
        <p>UPDATE YOUR PROFILE INFO:</p> <br />
        First Name: <input type="text" name="fname" id="fname" size="30" value="<%=rs.getString("first_name")%>"><br />
        Last Name: <input type="text" name="lname" id="lname" size="30" value="<%=rs.getString("last_name")   %>"><br />
        </br></br>

                        About You: </br><textarea name="bio" id="bio" rows="7" cols="30"><%=rs.getString("bio")%></textarea></br>
        <input type="submit"  name="updateinfo" id="updateinfo" value="Update Information">
        </form>  
        <%
          }     
            
        }catch(Exception ex){
            out.println(ex);
        }
        %>

      </div>

  <br />
<br />

<p>CHANGE YOUR PASSWORD:</p> <br />
<form action="ChangePassword" method="POST" name="changepassword">
Your Old Password: <input type="password" name="oldpassword" id="oldpassword" size="30" required><br /></br>
Your New Password: <input type="password" name="newpassword" id="newpassword" size="30" required><br /></br>
Repeat Password  : <input type="password" name="newpassword2" id="newpassword2" size="30" required><br /></br>
<input type="submit" name="senddata" id="senddata" value="Change Password" style="margin-top: 10px">
</form>
    </div>
    </br>
    </br>

    </div>




