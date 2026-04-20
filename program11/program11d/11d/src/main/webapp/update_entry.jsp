<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
    <h2>Update Employee Details</h2>
    <form action="update_process.jsp" method="post">
        Enter Emp No to Update: <input type="text" name="empno"><br><br>
        New Emp Name: <input type="text" name="newname"><br><br>
        New Basic Salary: <input type="text" name="newsalary"><br><br>
        <input type="submit" value="Update Employee">
    </form>
</body>
</html>