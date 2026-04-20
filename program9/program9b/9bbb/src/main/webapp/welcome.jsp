<%
String user = (String)session.getAttribute("username");

if(user==null)
{
    response.sendRedirect("expired.jsp");
    return;
}
%>

<html>
<body>
<h2>Hello <%= user %> !</h2>

<p>Wait 1 minute, then click below:</p>

<a href="welcome.jsp">Check Session</a>

</body>
</html>