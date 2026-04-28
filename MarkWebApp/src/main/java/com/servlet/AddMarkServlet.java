package com.servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;

@WebServlet("/AddMarkServlet")
public class AddMarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Match the names from your JSP
        String id = request.getParameter("studentID");
        String name = request.getParameter("studentName");
        String subject = request.getParameter("subject");
        String marks = request.getParameter("marks");
        String date = request.getParameter("examDate");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markdb", "root", "password");
            
            // Updated to match your 'studentmarks' table columns
            PreparedStatement ps = con.prepareStatement("INSERT INTO studentmarks (studentId, studentName, subject, marks, examDate) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, name);
            ps.setString(3, subject);
            ps.setInt(4, Integer.parseInt(marks));
            ps.setString(5, date);
            ps.executeUpdate();

            out.println("<html><head><meta http-equiv='refresh' content='3;url=index.jsp'>");
            out.println("<style>body{background:#f4f7f6; font-family:sans-serif; display:flex; justify-content:center; align-items:center; height:100vh; margin:0;} "
                    + ".box{background:white; padding:40px; border-radius:15px; box-shadow:10px 10px 0px #bebebe; border-left:10px solid #00adb5; text-align:center; width:350px;}</style></head><body>");
            out.println("<div class='box'><h2 style='color:#00adb5;'>✏️ Enrollment</h2><p>Student <b>" + name + "</b> added for " + subject + "!</p>");
            out.println("<p style='font-size:12px;color:#888;'>Returning to Desk...</p></div></body></html>");
            
            con.close();
        } catch (Exception e) { 
            out.println("<div style='color:red; text-align:center;'><h2>Error: " + e.getMessage() + "</h2></div>"); 
        }
    }
}