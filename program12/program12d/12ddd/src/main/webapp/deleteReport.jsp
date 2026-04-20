<%@ page import="java.sql.*" %>

<html>
<head>
<title>Salary Report</title>
</head>
<body>

<%
Connection con = null;
PreparedStatement ps1 = null;
PreparedStatement ps2 = null;
ResultSet rs = null;

try
{
    Class.forName("com.mysql.cj.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee",
        "root",
        "password");

    // Delete names starting with S
    ps1 = con.prepareStatement(
        "DELETE FROM Emp WHERE Emp_Name LIKE 'S%'");

    ps1.executeUpdate();

    // Select remaining records
    ps2 = con.prepareStatement(
        "SELECT * FROM Emp");

    rs = ps2.executeQuery();
%>

<h2>Salary Report</h2>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ <br>

<%
while(rs.next())
{
%>

Emp_No &nbsp;&nbsp;&nbsp;&nbsp; : <%= rs.getInt(1) %> <br>
Emp_Name : <%= rs.getString(2) %> <br>
Basic &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <%= rs.getDouble(3) %> <br>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ <br>

<%
}
}
catch(Exception e)
{
    out.println(e);
}
finally
{
    if(rs!=null) rs.close();
    if(ps1!=null) ps1.close();
    if(ps2!=null) ps2.close();
    if(con!=null) con.close();
}
%>

</body>
</html>