/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivy
 */
public class SearchUser extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection con = DriverManager.getConnection(connectionURL,"root","root");
            String search = request.getParameter("search");
           if(search == null || search.length() <1){
               out.println("<script>alert('Please enter something!')</script>");
               out.println("<script>window.history.go(-1);</script>");
               
           }
           else{
            out.println("<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"        <title>Friend Me</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"headerMenu\">\n" +
"            <div id=\"wrapper\">");
                out.println("<div class=\"logo\">\n" +
"                    <img src=\"img/logo.png\"/>\n" +
"                </div>                \n" +
"            </div>\n" +
"        </div>\n" +
"                    <div id=\"wrapperMain\">");
                out.println("<link href=\"css/indexStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<link href=\"css/home.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<div class=\"home\">");
                out.println("<div class=\"newsfeed\">");
                out.println("<img src=\"./img/makefriend.jpg\" width=\"798\" alt=\"\"/>");
                out.println("<h2> Here is the result you are searching for : </h2>");
                out.println("</div>");
                out.println("<div class=\"showResult\">");
                
            Statement st = con.createStatement();
            String sql = "SELECT * FROM users where username like '%" + search +"%' or first_name like '%" + search +"%' or last_name like '%" + search +"%'";
            ResultSet rs = st.executeQuery(sql);
            if(!rs.next() ){
                out.println("<img src='./img/sorry.png' style='margin-left:220' alt=''/>");
                out.println("<h2>Sorry, but there is ...No Result Found...</h2>");
                out.print("<div id='link'><a href=\"home.jsp\" class=\"myButton\">go back</a></div>");
            out.println("</div>\n" +
"<div class=\"footer\">\n" +
"           Copyright &copy;  Xiyi Li. All rights reserved.\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
            }else{
            while(rs.next()){
                out.println("<div class='displayResult'>"+" <center><a href=profile.jsp?id="+rs.getString("username")+"><img src="+"'" + rs.getString("profile_pic")+"'height='100' width='80' " +"alt=''/></center></a>"+"<p><a href=profile.jsp?id="+rs.getString("username")+">"+rs.getString("username")+"</a>"+
                 "<p></div>");
            } 
            out.println("</div>");
            out.print("<div id='link'><a href=\"home.jsp\" class=\"myButton\">go back</a></div>");
            out.println("</div>\n" +
"<div class=\"footer\">\n" +
"           Copyright &copy;  Xiyi Li. All rights reserved.\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");}
        
  
    } }
        catch(Exception ex)
            { out.println(ex);}    
        
    }
    }

    
