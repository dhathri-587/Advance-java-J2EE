<%--
    Session Management JSP Program
    Session expiry = 1 minute
--%>

<%@ page import="java.io.*" %>

<%
    // Get name from form
    String name = request.getParameter("username");

    // Create session
    HttpSession session1 = request.getSession();

    // Set session timeout (1 minute = 60 seconds)
    session1.setMaxInactiveInterval(60);

    // Store name in session
    session1.setAttribute("username", name);
%>

<html>
<head>
    <title>Session Page</title>
</head>
<body>

<%
    // Retrieve session value
    String user = (String) session1.getAttribute("username");

    if (user != null) {
%>

        <h2>Session Management Output</h2>
        <h3>Hello <%= user %> !</h3>

        <p><b>Session Time:</b> 1 minute</p>
        <p>Wait 1 minute and refresh to check expiry.</p>

<%
    } else {
%>

        <h3>Session expired. Please login again.</h3>
        <a href="index.html">Go Back</a>

<%
    }
%>

</body>
</html>