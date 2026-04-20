<%@ page import="java.sql.*" %>
<%
    String id = request.getParameter("empno");
    String name = request.getParameter("empname");
    String salary = request.getParameter("basicsalary");

    // Null check to prevent "Cannot parse null string" error
    if (id != null && name != null && salary != null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // CHANGE "your_password" TO YOUR ACTUAL MYSQL PASSWORD
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "password");
            
            String sql = "INSERT INTO emp (Emp_NO, Emp_Name, Basicsalary) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.setString(2, name);
            pstmt.setInt(3, Integer.parseInt(salary));
            
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            // Redirect to report page after successful insert
            response.sendRedirect("Employee.jsp");
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    } else {
        out.println("Please enter details through the form first.");
    }
%>