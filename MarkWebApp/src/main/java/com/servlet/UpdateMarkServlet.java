package com.servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;

@WebServlet("/UpdateMarkServlet")
public class UpdateMarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String subject = request.getParameter("subject"); // Ensure your update form has this
        String marks = request.getParameter("marks");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markdb", "root", "password");
            
            // FIX: Match table 'studentmarks' and columns 'marks', 'studentId', 'subject'
            PreparedStatement ps = con.prepareStatement("UPDATE studentmarks SET marks=? WHERE studentId=? AND subject=?");
            ps.setInt(1, Integer.parseInt(marks));
            ps.setInt(2, Integer.parseInt(id));
            ps.setString(3, subject);
            int i = ps.executeUpdate();

            out.println("<html><head><meta http-equiv='refresh' content='2;url=index.jsp'>");
            out.println("<style>body{background:#f4f7f6; font-family:sans-serif; display:flex; justify-content:center; align-items:center; height:100vh; margin:0;} "
                    + ".box{background:white; padding:40px; border-radius:15px; box-shadow:10px 10px 0px #bebebe; border-left:10px solid #4a90e2; text-align:center; width:350px;}</style></head><body>");
            out.println("<div class='box'>");
            if(i > 0) {
                out.println("<h2 style='color:#4a90e2;'>📝 Modification</h2><p>Marks updated for " + subject + "!</p>");
            } else {
                out.println("<h2 style='color:red;'>❌ Not Found</h2><p>Check ID and Subject name.</p>");
            }
            out.println("</div></body></html>");
            con.close();
        } catch (Exception e) { out.println("Error: " + e.getMessage()); }
    }
}