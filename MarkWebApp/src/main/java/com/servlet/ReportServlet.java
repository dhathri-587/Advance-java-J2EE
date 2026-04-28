package com.servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markdb", "root", "password");

            // SQL to get: 1. Total Unique Students, 2. Overall Class Average
            String summaryQuery = "SELECT COUNT(DISTINCT studentId) as totalStudents, AVG(marks) as classAvg FROM studentmarks";
            // SQL to get: Top 3 Students based on their average across all subjects
            String topScorersQuery = "SELECT studentName, AVG(marks) as avgPerc FROM studentmarks GROUP BY studentId ORDER BY avgPerc DESC LIMIT 3";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(summaryQuery);

            out.println("<html><head><style>");
            out.println("body{background:#f4f7f6; font-family:sans-serif; padding:40px;}");
            out.println(".report-container{max-width:800px; margin:auto; background:white; padding:30px; border-radius:20px; box-shadow:0 15px 35px rgba(0,0,0,0.1); border-top:10px solid #f1c40f;}");
            out.println(".stat-box{display:flex; justify-content:space-around; margin-bottom:30px; text-align:center;}");
            out.println(".stat-item{padding:20px; background:#f9f9f9; border-radius:10px; width:45%;}");
            out.println("h1, h2{color:#2c3e50;} table{width:100%; border-collapse:collapse;}");
            out.println("th, td{padding:12px; border-bottom:1px solid #eee; text-align:left;}");
            out.println("th{background:#f1c40f; color:white;}");
            out.println("</style></head><body>");

            out.println("<div class='report-container'>");
            out.println("<h1 style='text-align:center;'>📜 Academic Performance Report</h1>");

            if(rs.next()) {
                out.println("<div class='stat-box'>");
                out.println("<div class='stat-item'><h3>Total Students</h3><h2 style='color:#00adb5;'>" + rs.getInt("totalStudents") + "</h2></div>");
                out.println("<div class='stat-item'><h3>Class Average</h3><h2 style='color:#27ae60;'>" + String.format("%.2f", rs.getDouble("classAvg")) + "%</h2></div>");
                out.println("</div>");
            }

            // --- Top Scorers Section ---
            out.println("<h2>⭐ Top Performers</h2>");
            out.println("<table><tr><th>Rank</th><th>Student Name</th><th>Overall Percentage</th></tr>");
            
            ResultSet rsTop = stmt.executeQuery(topScorersQuery);
            int rank = 1;
            while(rsTop.next()) {
                out.println("<tr><td>" + (rank++) + "</td><td>" + rsTop.getString("studentName") + "</td><td>" + String.format("%.2f", rsTop.getDouble("avgPerc")) + "%</td></tr>");
            }
            out.println("</table>");

            out.println("<br><center><a href='index.jsp' style='color:#2c3e50; font-weight:bold;'>← Back to Dashboard</a></center>");
            out.println("</div></body></html>");

            con.close();
        } catch (Exception e) { 
            out.println("Error: " + e.getMessage()); 
        }
    }
}