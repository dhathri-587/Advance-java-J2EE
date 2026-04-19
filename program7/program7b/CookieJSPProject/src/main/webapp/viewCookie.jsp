<%--
    View Active Cookies JSP Page
--%>

<%@ page import="jakarta.servlet.http.Cookie" %>

<%
    Cookie[] cookies = request.getCookies();
%>

<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    if (cookies != null) {
%>

        <table border="1">
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>

<%
        for (Cookie c : cookies) {
%>

            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getValue() %></td>
            </tr>

<%
        }
%>

        </table>

<%
    } else {
%>

        <h3>No active cookies found</h3>

<%
    }
%>

<br><br>

<a href="index.html">Go Back</a>

</body>
</html>