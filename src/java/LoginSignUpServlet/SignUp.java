/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSignUpServlet;

import Database.testDbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.lang.String;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivy
 */
    public class SignUp extends HttpServlet {
    private Statement st1;
    private Statement st2;
    private Statement st3;
    private ResultSet rs1;
    private ResultSet rs2;
    private ResultSet rs3;
    private Connection con;

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
        String username = request.getParameter("username");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String email2 = request.getParameter("email2");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
//        check email and password validation
        if(!email2.equals(email)){
            out.println("<script>alert('please make sure you enter the same email!')</script>");
        } 
        else{}
            if(!password2.equals(password)){
                out.println("<script>alert('please make sure you enter the same password!')</script>");
            }
            else{}
        
       try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/friendme";
            con = DriverManager.getConnection(connectionURL,"root","root");
            st1 = con.createStatement();
            st2 = con.createStatement();
            String sql1 = "SELECT username from users where username = ('"+ username+"')";
            String sql2 = "SELECT email from users where email =('"+email+"')";
            rs1 =  st1.executeQuery(sql1);
            rs2 = st2.executeQuery(sql2);
            
            if (rs1.next()){
                out.println("<script>alert('Sorry, this username has already existed.</br> Please choose another one.');</script>");
                out.println("<script>window.history.go(-1);</script>");
            } else if(rs2.next()){
                out.println("<script>alert('Sorry, this email address has already been used. Please choose another one.');</script>");
                out.println("<script>window.history.go(-1);</script>");
            }

            else{
                st3 = con.createStatement();
                String sql3 = "INSERT INTO users (username,first_name,last_name,email,password,profile_pic,bio) values ('"+username + "','"
                        +fname + "','" +lname +"','" +email +"','" +password+ "'" +",'./img/default_profile.jpg'"+ ","+"'Hi, my name is "+fname+" "+lname+"')";
               st3.execute(sql3);
               out.println("<script>alert('Sign up success');</script>");
               out.println("<script>window.location.href = 'http://localhost:8080/FriendMe/index.jsp';</script>");
            }
        }        
        catch (SQLException ex)
        {
            out.println(ex);
        } catch (ClassNotFoundException ex) { 
          Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
      } 
       
       
       
       
       
            /* TODO output your page here. You may use following sample code. */
      
        
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
