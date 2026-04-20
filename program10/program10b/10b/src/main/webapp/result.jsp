<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Result Page</title>
    <style>
        .result-container {
            width: 400px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
        }
        .message {
            color: green;
            margin-bottom: 20px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="result-container">
        <h2>Processing Result</h2>
        <div class="<%= (request.getAttribute("message") != null && request.getAttribute("message").toString().contains("Invalid")) ? "error" : "message" %>">
            <%= request.getAttribute("message") %>
        </div>

        <% if(request.getAttribute("rollno") != null) { %>
            <h3>Submitted Data:</h3>
            <p>Roll No: <%= request.getAttribute("rollno") %></p>
            <p>Student Name: <%= request.getAttribute("studentname") %></p>
            <%
                int[] marks = (int[]) request.getAttribute("marks");
                if(marks != null){
                    for(int i=0; i<marks.length; i++){
            %>
                        <p>Subject <%= (i+1) %>: <%= marks[i] %></p>
            <%
                    }
                }
            %>
            <p>Average Marks: <%= request.getAttribute("average") %></p>
        <% } %>

        <a href="index.jsp">Back to Form</a>
    </div>
</body>
</html>
