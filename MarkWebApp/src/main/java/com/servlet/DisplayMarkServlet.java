package com.servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;

@WebServlet("/DisplayMarkServlet")
public class DisplayMarkServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markdb", "root", "password");

            // SQL Logic: Group by ID to handle multiple subjects and calculate Average
            String query = "SELECT studentId, studentName, SUM(marks) as total, COUNT(subject) as subCount FROM studentmarks GROUP BY studentId";
            ResultSet rs = con.createStatement().executeQuery(query);

            out.println("<html><head><style>");
            out.println("body{background:#f0f2f5; font-family:'Segoe UI', sans-serif; padding:40px;}");
            out.println("table{width:90%; margin:auto; background:white; border-radius:12px; border-collapse:collapse; box-shadow:0 10px 30px rgba(0,0,0,0.1); overflow:hidden;}");
            out.println("th{background:#00adb5; color:white; padding:15px; text-transform:uppercase;}");
            out.println("td{padding:12px; text-align:center; border-bottom:1px solid #eee;}");
            out.println(".card{background:white; margin:20px auto; padding:20px; width:85%; border-radius:12px; border-left:8px solid; box-shadow:0 4px 15px rgba(0,0,0,0.05);}");
            out.println("</style></head><body>");

            out.println("<h1 style='text-align:center; color:#222;'>📊 Student Performance Ledger</h1>");
            out.println("<table><tr><th>ID</th><th>Name</th><th>Subjects</th><th>Total Marks</th><th>Percentage</th></tr>");

            String topper = "";
            String struggler = "";
            double maxPerc = -1;
            double minPerc = 101;

            while(rs.next()){
                int id = rs.getInt("studentId");
                String name = rs.getString("studentName");
                int total = rs.getInt("total");
                int count = rs.getInt("subCount");
                double percentage = (double) total / count;

                // Track Topper and Struggler for the messages
                if(percentage > maxPerc) { maxPerc = percentage; topper = name; }
                if(percentage < minPerc) { minPerc = percentage; struggler = name; }

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + count + "</td>");
                out.println("<td>" + total + "</td>");
                out.println("<td><b>" + String.format("%.2f", percentage) + "%</b></td>");
                out.println("</tr>");
            }
            out.println("</table>");

            // --- POSITIVE REINFORCEMENT SECTION ---
            if(!topper.equals("")) {
                // Topper Message
                out.println("<div class='card' style='border-color: #2ecc71; margin-top:40px;'>");
                out.println("<h2 style='color:#27ae60; margin:0;'>🎉 Congratulations, " + topper + "!</h2>");
                out.println("<p style='font-size:1.1rem; color:#444;'>You are the top performer with <b>" + String.format("%.1f", maxPerc) + "%</b>. Your hard work is paying off—keep leading the way!</p></div>");

                // Encouragement Message for those who need to try again
                out.println("<div class='card' style='border-color: #f39c12;'>");
                out.println("<h2 style='color:#e67e22; margin:0;'>💪 Believe in Yourself, " + struggler + "!</h2>");
                out.println("<p style='font-size:1.1rem; color:#444;'>Never lose your hope. Remember, <b>failure is just a stepping stone to success</b>. Keep trying, keep learning, and your time to shine will come! ✨</p></div>");
            }

            out.println("<br><center><a href='index.jsp' style='text-decoration:none; color:#00adb5; font-weight:bold; font-size:1.1rem;'>← Back to Student Portal</a></center></body></html>");
            
            con.close();
        } catch (Exception e) { 
            out.println("<div style='text-align:center; padding:50px;'><h2>System Error: " + e.getMessage() + "</h2></div>"); 
        }
    }
}