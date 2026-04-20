<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Session Status</title>
</head>
<body>
    <%
        // Retrieve form data
        String name = request.getParameter("username");
        String expiryStr = request.getParameter("expiry");
        
        if (name != null && expiryStr != null) {
            // Store name in session
            session.setAttribute("user", name);
            
            // Convert minutes to seconds and set max inactive interval
            int expiryTime = Integer.parseInt(expiryStr) * 60;
            session.setMaxInactiveInterval(expiryTime);
            
            out.print("<h3>Hello " + name + "!</h3>");
            out.print("<p>Your session has been set for " + expiryStr + " minute(s).</p>");
        }
    %>

    <hr>
    <p>Click the link below to check if the session is still active:</p>
    <a href="checkSession.jsp">Check Session Status</a>
</body>
</html>