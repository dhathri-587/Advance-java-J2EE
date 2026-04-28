<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modify Entry</title>
    <style>
        body { background: linear-gradient(135deg, #0f0c29, #302b63, #24243e); font-family: 'Poppins', sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .container { background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(15px); border: 1px solid rgba(255, 255, 255, 0.2); border-radius: 25px; padding: 40px; width: 400px; color: white; text-align: center; }
        input { width: 100%; padding: 12px; margin: 10px 0; background: rgba(255, 255, 255, 0.1); border: 1px solid rgba(255, 255, 255, 0.2); color: white; border-radius: 10px; box-sizing: border-box; }
        button { width: 100%; padding: 15px; background: #00d2ff; border: none; color: white; font-weight: 600; border-radius: 15px; cursor: pointer; }
    </style>
</head>
<body>
    <div class="container">
        <h2>🛠️ Modify Entry</h2>
        <form action="UpdateMarkServlet" method="post">
            <input type="number" name="id" placeholder="Student ID" required>
            <input type="text" name="subject" placeholder="Subject Name" required>
            <input type="number" name="marks" placeholder="Enter New Marks" required>
            <button type="submit">UPDATE DATA</button>
        </form>
        <br><a href="index.jsp" style="color: #ccc; text-decoration: none; font-size: 0.8rem;">← Cancel</a>
    </div>
</body>
</html>