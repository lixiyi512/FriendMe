package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("<link href=\"css/indexStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<!--<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/indexStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("       \n");
      out.write("        <title>Login/Register</title>\n");
      out.write("    </head>\n");
      out.write("    <body>-->\n");
      out.write("        <div class=\"main\">\n");
      out.write("<!--       <div class=\"login\">\n");
      out.write("            <h2>Already a Memeber? Login below ...</h2>\n");
      out.write("            <form action=\"index.php\" method=\"post\" name=\"form1\" id=\"form1\">\n");
      out.write("\t\t\t\t<input type=\"text\" size=\"40\" name=\"user_login\" id=\"user_login\" class=\"auto-clear\" value=\"Username ...\" /><br /><br/>\n");
      out.write("\t\t\t\t<input type=\"text\" size=\"40\" name=\"password_login\" id=\"password_login\" value=\"Password ...\" /><br /><br/>\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"button\" id=\"button\" value=\"Login to your account\">\n");
      out.write("\t\t\t</form>\n");
      out.write("            </div>-->\n");
      out.write("          \n");
      out.write("            <div id=\"mode\">\n");
      out.write("                <h1>LOG IN/ CREATE ACCOUNT</h1>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"left\">\n");
      out.write("                <h1>Existing User</h1><br>\n");
      out.write("                <p>Enter your e-mail address and password to log in.</p><br>\n");
      out.write("\t\t<form action=\" \" method=\"post\">\n");
      out.write("                    \n");
      out.write("                    <p>Email: <input type=\"text\" name=\"email\" size=\"30\"> <br> <br>\n");
      out.write("                    <p>Password: <input type=\"password\" name=\"pass\" size=\"30\"> <br> <br>\t\t\t\n");
      out.write("\t\t\t<p><input type=\"submit\" value=\"LOG IN\" class=\"submit\">\n");
      out.write("\t\t</form>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"right\">\n");
      out.write("                <h1>New User</h1><br>\n");
      out.write("        <p>If you still don't have an account, use this option to access the registration form.</p>\n");
      out.write("        <br>\n");
      out.write("        <p>By signing up, you are beginning the journey of making tons of friends!.</p>\n");
      out.write("        <br>\n");
      out.write("        <a href=\"signUp.jsp\"><p><input type=\"button\" value=\"CREATE ACCOUNT\" class=\"submit\"></p></a>\n");
      out.write("   \n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("      \n");
      out.write("        </div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("<!--    </body>\n");
      out.write("</html>-->\n");
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
