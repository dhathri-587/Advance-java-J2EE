<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Verify Session</title>
</head>
<body>
    <%
        String user = (String) session.getAttribute("user");
        
        if (user != null) {
            out.print("<h2>Session Active: Hello " + user + "!</h2>");
            out.print("<p>The session is still valid.</p>");
        } else {
            out.print("<h2>Session Expired!</h2>");
            out.print("<p>You waited too long, or the session was invalidated.</p>");
        }
    %>
    <br>
    <a href="index.html">Back to Home</a>
</body>
</html>