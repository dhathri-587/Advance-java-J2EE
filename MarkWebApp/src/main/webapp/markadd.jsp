<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Record</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body { background: linear-gradient(135deg, #0f0c29, #302b63, #24243e); font-family: 'Poppins', sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .container { background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(15px); border: 1px solid rgba(255, 255, 255, 0.2); border-radius: 25px; padding: 40px; width: 400px; color: white; text-align: center; }
        input { width: 100%; padding: 12px; margin: 10px 0; background: rgba(255, 255, 255, 0.1); border: 1px solid rgba(255, 255, 255, 0.2); color: white; border-radius: 10px; box-sizing: border-box; outline: none; }
        button { width: 100%; padding: 15px; background: #00d2ff; border: none; color: white; font-weight: 600; border-radius: 15px; cursor: pointer; transition: 0.3s; margin-top: 10px; }
        button:hover { background: #008fbc; box-shadow: 0 5px 15px rgba(0, 210, 255, 0.4); }
    </style>
</head>
<body>
    <div class="container">
        <h2>📝 Enrollment</h2>
        <form action="AddMarkServlet" method="post">
            <input type="number" name="studentID" placeholder="Roll Number (ID)" required>
            <input type="text" name="studentName" placeholder="Student Full Name" required>
            <input type="text" name="subject" placeholder="Subject (e.g., Java)" required>
            <input type="number" name="marks" placeholder="Marks Obtained" required>
            <input type="date" name="examDate" required>
            <button type="submit">SAVE TO CLOUD</button>
        </form>
        <br><a href="index.jsp" style="color: #ccc; text-decoration: none; font-size: 0.8rem;">← Back to Home</a>
    </div>
</body>
</html>