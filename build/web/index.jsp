

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%--<jsp:include page="header.jsp"/>--%>
<link href="css/indexStyle.css" rel="stylesheet" type="text/css"/>
        <div class="main">          
            <div id="mode">
                <h1>LOG IN/ CREATE ACCOUNT</h1>
            </div>
            <div id="left">
                <h1>Existing User</h1><br>
                <p>Enter your username and password to log in.</p><br>
		<form action="Login " method="POST">
                    
                    <p>Username: <input type="text" name="username" size="30" required> <br> <br>
                    <p>Password: <input type="password" name="password" size="30" required> <br> <br>			
			<p><input type="submit" value="LOG IN" class="submit">
		</form>
            </div>
            <div id="right">
                <h1>New User</h1><br>
        <p>If you still don't have an account, use this option to access the registration form.</p>
        <br>
        <p>By signing up, you are beginning the journey of making tons of friends!.</p>
        <br>
        <p><input type="button" value="SIGN UP" class="submit" onclick="window.location.href='signUp.jsp'"></p>
   
    </div>

        </div>
<%--<jsp:include page="footer.jsp"/>--%>
<%@ include file="footer.jsp"%>

