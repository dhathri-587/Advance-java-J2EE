<%@include file="chalkboard-bg.jsp" %>
<%@ page import="java.util.List, com.model.StudentMark" %>
<div class="card" style="width:80%;">
    <h2>All Student Marks</h2>
    <table>
        <tr><th>ID</th><th>Name</th><th>Subject</th><th>Marks</th><th>Date</th></tr>
        <% 
            List<StudentMark> list = (List<StudentMark>)request.getAttribute("list");
            if(list != null) {
                for(StudentMark s : list) {
        %>
        <tr>
            <td><%= s.getStudentID() %></td>
            <td><%= s.getStudentName() %></td>
            <td><%= s.getSubject() %></td>
            <td><%= s.getMarks() %></td>
            <td><%= s.getExamDate() %></td>
        </tr>
        <% }} %>
    </table>
    <br><a href="index.jsp" style="color:#66fcf1;">Back to Menu</a>
</div>