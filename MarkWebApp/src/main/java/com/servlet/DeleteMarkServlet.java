package com.servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;

@WebServlet("/DeleteMarkServlet")
public class DeleteMarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id"); // Matches the 'name' in your delete form

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markdb", "root", "password");
            
            // FIX: Changed table to 'studentmarks' and column to 'studentId'
            PreparedStatement ps = con.prepareStatement("DELETE FROM studentmarks WHERE studentId=?");
            ps.setInt(1, Integer.parseInt(id));
            int i = ps.executeUpdate();

            out.println("<html><head><meta http-equiv='refresh' content='2;url=index.jsp'>");
            out.println("<style>body{background:#f4f7f6; font-family:sans-serif; display:flex; justify-content:center; align-items:center; height:100vh; margin:0;} "
                    + ".box{background:white; padding:40px; border-radius:15px; box-shadow:10px 10px 0px #bebebe; border-left:10px solid #e74c3c; text-align:center; width:350px;}</style></head><body>");
            out.println("<div class='box'><h2 style='color:#e74c3c;'>🗑️ Removal</h2>");
            
            if(i > 0) {
                out.println("<p>Record ID <b>" + id + "</b> deleted.</p>");
            } else {
                out.println("<p style='color:red;'>ID not found.</p>");
            }
            out.println("</div></body></html>");
            con.close();
        } catch (Exception e) { out.println("Error: " + e.getMessage()); }
    }
}