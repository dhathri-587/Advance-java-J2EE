<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Marks Entry</title>
    <style>
        .form-container {
            width: 400px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
        }
        .form-field {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Enter Student Data</h2>
        <form action="processResult" method="POST">
            <div class="form-field">
                <label for="rollno">Roll No:</label>
                <input type="text" id="rollno" name="rollno" required>
            </div>
            <div class="form-field">
                <label for="studentname">Student Name:</label>
                <input type="text" id="studentname" name="studentname" required>
            </div>
            <div class="form-field">
                <label for="sub1">Subject 1:</label>
                <input type="number" id="sub1" name="sub1" min="0" max="100" required>
            </div>
            <div class="form-field">
                <label for="sub2">Subject 2:</label>
                <input type="number" id="sub2" name="sub2" min="0" max="100" required>
            </div>
            <div class="form-field">
                <label for="sub3">Subject 3:</label>
                <input type="number" id="sub3" name="sub3" min="0" max="100" required>
            </div>
            <div class="form-field">
                <label for="sub4">Subject 4:</label>
                <input type="number" id="sub4" name="sub4" min="0" max="100" required>
            </div>
            <div class="form-field">
                <label for="sub5">Subject 5:</label>
                <input type="number" id="sub5" name="sub5" min="0" max="100" required>
            </div>
            <div class="form-field">
                <input type="submit" value="Submit">
            </div>
        </form>
    </div>
</body>
</html>
