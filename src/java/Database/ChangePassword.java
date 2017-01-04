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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivy
 */
public class ChangePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String oldpass = request.getParameter("oldpassword");
            String newpass = request.getParameter("newpassword");
            String repass = request.getParameter("newpassword2");
            String username = (String)request.getSession().getAttribute("username");
          if(repass != newpass ){
                out.println("<script>alert('Your new password doesn't match!');</script>");
                out.println("<script>window.history.go(-1);</script>");
            }     
             //     tried to make more constrain to control this part: check whether the entered current password is equal to real password 
//            else{
//              try{
//                Class.forName("org.apache.derby.jdbc.ClientDriver");
//                String connectionURL = "jdbc:derby://localhost:1527/friendme";
//                Connection con = DriverManager.getConnection(connectionURL,"root","root");
//                Statement st = con.createStatement();
//                String sql = "SELECT password from users where username ='"+ username+"'";
//                ResultSet rs = st.executeQuery(sql);
//                String oldpassword = rs.getString("password");
//                if(oldpassword != oldpass){
//                    out.println("<acript>alert('make sure you enter your current password right.');</script>");
//                    
//                }else{
//                    Statement st2 = con.createStatement();
//                    String sql2 = "UPDATE users SET password = '"+newpass+"' where username ='" + username +"'";
//                    st2.execute(sql2);
//                out.println("<script>alert('password update success');</script>");
//                out.println("<script>window.location.href = 'http://localhost:8080/FriendMe/setting.jsp';</script>");
//                }
//            }catch(Exception ex){
//                out.println(ex);
//            }
//              }
         //have error when i tried to use else statement. 
         try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String connectionURL = "jdbc:derby://localhost:1527/friendme";
                Connection con = DriverManager.getConnection(connectionURL,"root","root");
                Statement st = con.createStatement();
                    Statement st2 = con.createStatement();
                    String sql2 = "UPDATE users SET password = '"+newpass+"' where username ='" + username +"'";
                    st2.execute(sql2);
                out.println("<script>alert('password update success');</script>");
                out.println("<script>window.location.href = 'http://localhost:8080/FriendMe/setting.jsp';</script>");
                }
            catch(Exception ex){
                out.println(ex);
            }
          
          }
              
          

            
        
        
 


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
