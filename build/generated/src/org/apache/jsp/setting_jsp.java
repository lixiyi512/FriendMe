package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class setting_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
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
                        out.println("<a href='profile.jsp'>"+username+"'s Profile</a>");
                        out.println("<a href='setting.jsp'>Setting</a>");
                        out.println("<a href='http://localhost:8080/FriendMe/LogOut'>Log Out</a>");
                        out.println("</div>");
                    
                }
                    
                    
      out.write("\n");
      out.write("                \n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <img src=\"img/logo.png\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"searchBox\">\n");
      out.write("                    <form action=\"\" method=\"GET\" id=\"search\">\n");
      out.write("                        <input type=\"text\" name=\"search\" size=\"20\" placeholder=\"Search findFriends ...\">\n");
      out.write("                         <input type=\"submit\" id=\"searchSubmit\" value=\"search\" />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                \n");
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
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("<link href=\"css/indexStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"css/setting.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<h2>Edit your Account Settings below</h2>\n");
      out.write("<hr />\n");
      out.write("<div class=\"left\">\n");
      out.write("<p>UPLOAD YOUR PROFILE PHOTO:</p>\n");
      out.write("<form action=\"\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("<img src=\"");
      out.print( session.getAttribute("username") );
      out.write("\" width=\"150\" height=\"205\"/>\n");
      out.write("<input type=\"file\" name=\"profilepic\" style=\"padding-left: 28px; padding-bottom: 15px; padding-top: 20px;\" /><br />\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"submit\" name=\"uploadpic\" value=\"Upload Image\"  >\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<div class=\"right\">\n");
      out.write("    <div class=\"up\">\n");
      out.write("<form action=\"account_settings.php\" method=\"post\">\n");
      out.write("<p>CHANGE YOUR PASSWORD:</p> <br />\n");
      out.write("Your Old Password: <input type=\"text\" name=\"oldpassword\" id=\"oldpassword\" size=\"30\"><br />\n");
      out.write("Your New Password: <input type=\"text\" name=\"newpassword\" id=\"newpassword\" size=\"30\"><br />\n");
      out.write("Repeat Password  : <input type=\"text\" name=\"newpassword2\" id=\"newpassword2\" size=\"30\"><br />\n");
      out.write("<input type=\"submit\" name=\"senddata\" id=\"senddata\" value=\"Change Password\">\n");
      out.write("</form>\n");
      out.write("    </div>\n");
      out.write("    </br>\n");
      out.write("    </br>\n");
  
    try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/friendme","root","root");
            Statement st = con.createStatement();
            String sql = "SELECT first_name,last_name,bio from users where username = ('"+ username+"')";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
  
      out.write("               \n");
      out.write("        <form action=\"\" method=\"post\">\n");
      out.write("        <p>UPDATE YOUR PROFILE INFO:</p> <br />\n");
      out.write("        First Name: <input type=\"text\" name=\"fname\" id=\"fname\" size=\"40\" value=\"");
      out.print(rs.getString("first_name"));
      out.write("\"><br />\n");
      out.write("        Last Name: <input type=\"text\" name=\"lname\" id=\"lname\" size=\"40\" value=\"");
      out.print(rs.getString("last_name")   );
      out.write("\"><br />\n");
      out.write("        About You: <textarea name=\"bio\" id=\"bio\" rows=\"7\" cols=\"40\">");
      out.print(rs.getString("bio"));
      out.write("</textarea>\n");
      out.write("        <input type=\"submit\" name=\"updateinfo\" id=\"updateinfo\" value=\"Update Information\">\n");
      out.write("        </form>  \n");
      out.write("        ");

          }     
            
        }catch(Exception ex){
            out.println(ex);
        }
        
      out.write("\n");
      out.write("\n");
      out.write("     \n");
      out.write("\n");
      out.write("  <br />\n");
      out.write("<br />\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
