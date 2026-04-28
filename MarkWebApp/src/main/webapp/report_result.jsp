<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Academic Statement</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body { background: #0f0c29; font-family: 'Poppins', sans-serif; color: white; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; }
        .result-card { background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(20px); border-radius: 30px; padding: 40px; width: 500px; border: 1px solid rgba(255, 255, 255, 0.2); box-shadow: 0 20px 50px rgba(0,0,0,0.3); text-align: center; }
        .percentage-circle { width: 120px; height: 120px; border-radius: 50%; border: 8px solid #00d2ff; display: flex; align-items: center; justify-content: center; margin: 20px auto; font-size: 1.5rem; font-weight: 600; color: #00d2ff; }
        .info-row { display: flex; justify-content: space-between; padding: 10px 0; border-bottom: 1px solid rgba(255,255,255,0.1); }
        .btn-home { margin-top: 30px; display: inline-block; padding: 12px 30px; background: #00d2ff; color: white; text-decoration: none; border-radius: 15px; font-weight: 600; }
    </style>
</head>
<body>
    <div class="result-card">
        <h2 style="margin-bottom: 5px;">Academic Statement</h2>
        <p style="color: #ccc; font-size: 0.9rem;">Official Record of Performance</p>
        
        <div class="percentage-circle">${percentage}%</div>
        
        <div class="info-row"><span>Student Name:</span> <b>${studentName}</b></div>
        <div class="info-row"><span>Roll Number:</span> <b>${studentId}</b></div>
        <div class="info-row"><span>Status:</span> <b style="color: #2ecc71;">Passed</b></div>
        
        <a href="index.jsp" class="btn-home">Return to Desk</a>
    </div>
</body>
</html>