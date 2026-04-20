<%@ page import="java.sql.*" %>
<%
    String id = request.getParameter("empno");
    String name = request.getParameter("newname");
    String salary = request.getParameter("newsalary");

    if (id != null && name != null && salary != null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Update the password field below
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "password");
            
            String sql = "UPDATE emp SET Emp_Name = ?, Basicsalary = ? WHERE Emp_NO = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, name);
            pstmt.setInt(2, Integer.parseInt(salary));
            pstmt.setInt(3, Integer.parseInt(id));
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                out.println("<h3>Employee ID " + id + " updated successfully!</h3>");
                out.println("<a href='Employee.jsp'>View Salary Report</a>");
            } else {
                out.println("<h3>Error: Employee ID not found.</h3>");
                out.println("<a href='update_entry.jsp'>Try Again</a>");
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
%>