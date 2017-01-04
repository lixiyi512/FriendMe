
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="<%="header.jsp"%>"/>
<link href="css/indexStyle.css" rel="stylesheet" type="text/css"/>
<script src="js/main.js" type="text/javascript"></script>
        <div class="main">
            <div id="mode">
                <h1>SIGN UP BELOW ...</h1>
            </div>
            <br>
         <center>
        <form action="SignUp" method="POST">
            <input type="text" size="40" name="username"  id="username" placeholder="Username" required> <br><br>
            <input type="text" size="40" name="fname"  id="fname" placeholder="First Name" required> <br><br>
           <input type="text" size="40" name="lname"  id="lname" placeholder="Last Name" required><br><br>
           <input type="email" size="40" name="email" id="email" placeholder="Email" required><br><br>
           <input type="email" size="40" name="email2"  id="email2" placeholder="Re-enter email" required><br><br>
           <input type="password" size="40" name="password" id="password" placeholder="Password" required><br><br>
           <input type="password" size="40" name="password2" id="password2" placeholder="Re-enter password" required><br><br>
           <input type="submit" name="submit" value="Sign Up!" class="submit" onclick="signUp()">
        </form>         
    </center>

        <br>
   
        </div>
        
    <jsp:include page="<%="footer.jsp"%>"/>
