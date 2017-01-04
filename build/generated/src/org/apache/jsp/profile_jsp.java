package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Friend Me</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"headerMenu\">\n");
      out.write("            <div id=\"wrapper\">\n");
      out.write("                ");
 
                    String username = (String)request.getSession().getAttribute("username");
                if(username != null){
                        out.println("<div class='menu'>");
                        out.println("<a href='home.jsp'>Home</a>");
                        out.println("<a href='profile.jsp?id="+username+"'>"+username+"'s Profile</a>");
                        out.println("<a href='setting.jsp'>Setting</a>");
                        out.println("<a href='http://localhost:8080/FriendMe/LogOut'>Log Out</a>");
                        out.println("</div>");
                    
                }
                    
                    
      out.write("\n");
      out.write("                \n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <img src=\"img/logo.png\"/>\n");
      out.write("                </div>                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                    <div id=\"wrapperMain\">\n");
      out.write("        \n");
      out.write("<!--        <div class=\"footer\">\n");
      out.write("           Copyright &copy;  Xiyi Li. All rights reserved.\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>-->\n");
      out.write("\n");
      out.write("<link href=\"css/indexStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"css/profile.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<script src=\"js/main.js\" type=\"text/javascript\"></script>\n");
      out.write("<!--<script src=\"js/main.js\" type=\"text/javascript\"></script>-->\n");
        
        if(username ==null){
        out.println("<script>alert('Please login/sign up to make friends!');</script>");
        out.println("<script>window.location.href = 'http://localhost:8080/FriendMe/index.jsp';</script>");
        }

      out.write('\n');

 String u1=request.getParameter("id");
  String username1="";
 if(u1=="")
          username1=(String)session.getAttribute("username");
 else if(u1!="")
      username1=u1;

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"postForm\">\n");
      out.write("    <form action=\"send_post?id1= ");
      out.print(username);
      out.write(" &id2= ");
      out.print(username1);
      out.write("\" method=\"POST\">\n");
      out.write("    <textarea id=\"post\" name=\"post\" rows=\"5\" cols=\"80\"></textarea>\n");
      out.write("    <input type=\"submit\" name=\"send\"  value=\"Post\" style=\"background-color: #DCE5EE; float: right; border: 1px solid #666; color:#666;height:73px; width: 65px;\" />\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"profilePosts\">\n");
      out.write("    <div class=\"postList\">\n");
      out.write("    ");
 
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/friendme","root","root");
            Statement st1 = con.createStatement();
            String sql1 = "SELECT post,posted_by,posted_to,date from posts where posted_to = '"+username+"' ";
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
            out.println("<div class='posted_by'><a href=profile.jsp?id="+username+">"+username+"</a>"+" -- "+rs1.getString("date")+" -- "+ rs1.getString("post")+"</br></div><hr/>");
            }
        }catch(Exception ex){
            out.println(ex);
        }
        
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--<div class=\"friendList\">\n");
      out.write("    ");

    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection conn = DriverManager.getConnection(connectionURL,"root","root");
            Statement st = conn.createStatement();
            String q1 = new String("SELECT username,first_name,profile_pic FROM users");
            ResultSet rs =  st.executeQuery(q1);
           
            while(rs.next())
           {
               
             out.println("<li>"+" <img src="+"'" + rs.getString("profile_pic")+"'height='50' width='45'" +"alt=''/>"+"<a href=profile.jsp?id="+rs.getString("username")+">"+rs.getString("username")+"</a>"+
                 "  "+rs.getString("first_name")+"</li>");
           }
       }
       catch(Exception ex)
                 {
            out.println(ex);  
        }
    
      out.write("\n");
      out.write("</div>-->\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"profileimg\">\n");
      out.write("    ");

    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            Connection conn = DriverManager.getConnection(connectionURL,"root","root");
            Statement st = conn.createStatement();
            String q1 = "SELECT profile_pic FROM users where username =  '"+username1+"' ";;
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
    
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</br>   \n");
      out.write("   \n");
      out.write("<div class=\"textHeader\">");
      out.print( username1 );
      out.write("'s Bio</div>\n");
      out.write("<div class=\"profileLeftSideContent\">\n");
      out.write("    ");

    
    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/friendme","root","root");
            Statement st2 = con.createStatement();
            String sql2 = "SELECT bio from users where username = '"+ username1+"'";
            ResultSet rs2 = st2.executeQuery(sql2);
            while(rs2.next()){
                String bio=rs2.getString("bio");
                out.println(bio);
            }
        }catch(Exception ex){
            out.println(ex);
        }
    
    
    
    
    
    
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<div class=\"footer\">\n");
      out.write("           Copyright &copy;  Xiyi Li. All rights reserved.\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("    ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
