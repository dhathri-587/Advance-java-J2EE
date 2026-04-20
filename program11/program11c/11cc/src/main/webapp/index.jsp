<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Entry</title>
</head>
<body>
    <h2>Enter Employee Details</h2>
    <form action="insert.jsp" method="post">
        Emp No: <input type="text" name="empno"><br><br>
        Emp Name: <input type="text" name="empname"><br><br>
        Basic Salary: <input type="text" name="basicsalary"><br><br>
        <input type="submit" value="Add Employee">
    </form>
    <br>
    <a href="Employee.jsp">View Salary Report</a>
</body>
</html>