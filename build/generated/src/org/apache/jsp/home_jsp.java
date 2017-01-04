package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"css/home.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
        
        if(username ==null){
        out.println("<script>alert('Please login/sign up to make friends!');</script>");
        out.println("<script>window.location.href = 'http://localhost:8080/FriendMe/index.jsp';</script>");
        }
        else{
            
        }

      out.write("\n");
      out.write("<div class=\"home\">\n");
      out.write("<div class=\"newsfeed\">\n");
      out.write("    \n");
      out.write("    <img src=\"./img/makefriend.jpg\" width=\"798\" alt=\"\"/>\n");
      out.write("    <h2>  <i style=\"font-size: 18px\">Hi,");
      out.print( username );
      out.write("!</i>  Welcome to FINDFRIENDS:) </h2>\n");
      out.write("</div>\n");
 
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
        
        
      out.write("\n");
      out.write("<div class=\"friendList\">\n");
      out.write("    <h1>Below are the users, you can go to their profile page and get to know them by clicking their nick name </h1>\n");
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
             out.println("<div class='userdisplay'>"+" <center><a href=profile.jsp?id="+rs.getString("username")+"><img src="+"'" + rs.getString("profile_pic")+"'height='50' width='45' " +"alt=''/></a></center>"+"<p><a href=profile.jsp?id="+rs.getString("username")+">"+rs.getString("username")+"</a>"+
                 "<p></div>");
           }
       }
       catch(Exception ex)
                 {
            out.println(ex);  
        }
    
      out.write("\n");
      out.write("</div>\n");
      out.write("<div class=\"searchDisplay\">\n");
      out.write("<div class=\"search\">\n");
      out.write("    <p>Type the username/first name or last name of the person you are looking for.</p>\n");
      out.write("                    <form action=\"SearchUser\" method=\"GET\" id=\"search\">\n");
      out.write("                        <input type=\"text\" name=\"search\" size=\"10\" placeholder=\"type ...\">\n");
      out.write("                        \n");
      out.write("                         <input type=\"submit\" id=\"searchSubmit\" value=\"search\" />\n");
      out.write("                    </form>\n");
      out.write("     </div>\n");
      out.write("    <img src=\"./img/friend.jpg\" alt=\"\" width=\"340\"/>        \n");
      out.write("</div>\n");
      out.write("</div>\n");
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
      out.write("     \n");
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
