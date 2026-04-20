<%@ page import="java.sql.*" %>
<%
    String id = request.getParameter("empno");
    String name = request.getParameter("empname");
    String salary = request.getParameter("basicsalary");
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "password");
        String sql = "INSERT INTO emp (Emp_NO, Emp_Name, Basicsalary) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(id));
        pstmt.setString(2, name);
        pstmt.setInt(3, Integer.parseInt(salary));
        pstmt.executeUpdate();
        response.sendRedirect("Employee.jsp");
        conn.close();
    } catch (Exception e) { out.println(e.getMessage()); }
%>