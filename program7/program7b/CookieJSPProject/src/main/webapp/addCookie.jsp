<%--
    Add Cookie JSP Page
    Stores cookie with name, domain, max age
--%>

<%@ page import="jakarta.servlet.http.Cookie" %>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    String maxageStr = request.getParameter("maxage");

    int maxage = Integer.parseInt(maxageStr);

    // Create cookies
    Cookie c1 = new Cookie("name", name);
    Cookie c2 = new Cookie("domain", domain);

    // Set max age
    c1.setMaxAge(maxage);
    c2.setMaxAge(maxage);

    // Add cookies to response
    response.addCookie(c1);
    response.addCookie(c2);
%>

<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<h2>Cookie Added Successfully!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= maxage %> seconds</p>

<br>

<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>