<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Success!</title>
    <meta http-equiv="refresh" content="3;url=index.jsp">
    <style>
        body { background: radial-gradient(circle, #1a1a2e, #16213e); height: 100vh; display: flex; justify-content: center; align-items: center; font-family: 'Poppins', sans-serif; color: white; margin: 0; }
        .success-box { background: rgba(255, 255, 255, 0.05); padding: 50px; border-radius: 25px; text-align: center; border: 1px solid rgba(46, 204, 113, 0.3); }
        .checkmark { font-size: 80px; color: #2ecc71; margin-bottom: 20px; display: block; }
        h1 { margin: 0; font-weight: 600; }
        p { color: #888; margin-top: 10px; }
    </style>
</head>
<body>
    <div class="success-box">
        <span class="checkmark">✔</span>
        <h1>Update Successful</h1>
        <p>Your changes have been saved to the database.</p>
        <p style="font-size: 11px;">Redirecting back to portal...</p>
    </div>
</body>
</html>