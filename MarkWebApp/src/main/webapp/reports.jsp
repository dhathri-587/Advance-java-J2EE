<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Academic Report</title>
    <style>
        body { background: linear-gradient(135deg, #0f0c29, #302b63, #24243e); font-family: 'Poppins', sans-serif; color: white; padding: 50px; }
        .report-card { background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(15px); border-radius: 25px; padding: 40px; max-width: 800px; margin: auto; border: 1px solid rgba(255, 255, 255, 0.2); }
        h1 { color: #f1c40f; text-align: center; }
        .stat-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; margin: 30px 0; }
        .stat-item { background: rgba(0, 210, 255, 0.1); padding: 20px; border-radius: 15px; text-align: center; border: 1px solid #00d2ff; }
    </style>
</head>
<body>
    <div class="report-card">
        <h1>📜 Final Academic Report</h1>
        <div class="stat-grid">
            <div class="stat-item"><h3>Total Students</h3><h2>${totalStudents}</h2></div>
            <div class="stat-item"><h3>Class Average</h3><h2>${classAvg}%</h2></div>
        </div>
        <center><a href="index.jsp" style="color: #00d2ff; text-decoration: none;">← Return to Portal</a></center>
    </div>
</body>
</html>