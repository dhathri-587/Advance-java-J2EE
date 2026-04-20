<%@ page import="java.sql.*" %>
<html><body><pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                               Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
    int total = 0;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "password");
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM emp");
        while (rs.next()) {
            int s = rs.getInt("Basicsalary");
            total += s;
            out.println("Emp_No   : " + rs.getInt("Emp_NO") + "\nEmp_Name : " + rs.getString("Emp_Name") + "\nBasic    : " + s);
            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        conn.close();
    } catch (Exception e) { out.println(e.getMessage()); }
%>
Grand Salary : <%= total %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre></body></html>