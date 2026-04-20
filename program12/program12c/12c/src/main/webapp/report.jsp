<%@ page import="java.sql.*" %>

<html>
<body>

<%
String ch = request.getParameter("ch");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee", "root", "password");

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM Emp WHERE Emp_Name LIKE ?");

    ps.setString(1, ch + "%");

    ResultSet rs = ps.executeQuery();
%>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
    while(rs.next()) {
%>
Emp_No     : <%= rs.getInt("Emp_NO") %>
Emp_Name   : <%= rs.getString("Emp_Name") %>
Basic      : <%= rs.getInt("Basicsalary") %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<%
    }
%>
</pre>

<%
    con.close();
} catch(Exception e) {
    out.println(e);
}
%>

</body>
</html>