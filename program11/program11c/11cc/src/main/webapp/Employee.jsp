<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Salary Report</title>
    <style>
        pre { font-family: "Courier New", Courier, monospace; font-weight: bold; }
    </style>
</head>
<body>
<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                               Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
    int grandTotal = 0;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM emp");

        while (rs.next()) {
            int empNo = rs.getInt("Emp_NO");
            String name = rs.getString("Emp_Name");
            int basic = rs.getInt("Basicsalary");
            grandTotal += basic;

            out.println("Emp_No   : " + empNo);
            out.println("Emp_Name : " + name);
            out.println("Basic    : " + basic);
            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        conn.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>

Grand Salary : <%= grandTotal %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>
<br>
<a href="index.jsp">Back to Entry Form</a>
</body>
</html>