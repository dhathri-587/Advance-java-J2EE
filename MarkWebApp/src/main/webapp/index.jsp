<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Management Portal</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <script src="https://unpkg.com/lucide@latest"></script>
    
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            /* Vibrant Gradient Background */
            background: linear-gradient(135deg, #0f0c29, #302b63, #24243e);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }

        /* The Glass Effect Container */
        .container {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(15px);
            -webkit-backdrop-filter: blur(15px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            border-radius: 25px;
            padding: 50px;
            width: 500px;
            box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.5);
            text-align: center;
            color: white;
        }

        .header-icon {
            color: #00d2ff;
            margin-bottom: 10px;
        }

        h1 {
            font-size: 2rem;
            font-weight: 600;
            margin-bottom: 10px;
            letter-spacing: 1px;
            color: #ffffff;
        }

        p {
            font-size: 0.9rem;
            color: #ccc;
            margin-bottom: 30px;
        }

        /* Modern Navigation Links */
        .nav-menu {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .nav-item {
            display: flex;
            align-items: center;
            background: rgba(255, 255, 255, 0.08);
            padding: 15px 20px;
            border-radius: 15px;
            text-decoration: none;
            color: #fff;
            font-weight: 400;
            transition: all 0.3s ease;
            border: 1px solid transparent;
        }

        .nav-item:hover {
            background: rgba(255, 255, 255, 0.2);
            transform: translateY(-3px);
            border-color: #00d2ff;
            box-shadow: 0 5px 15px rgba(0, 210, 255, 0.3);
        }

        .icon-box {
            margin-right: 15px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #00d2ff;
        }

        .admin-tag {
            font-size: 0.7rem;
            background: #ff4b2b;
            padding: 2px 8px;
            border-radius: 10px;
            margin-left: auto;
            text-transform: uppercase;
            font-weight: 600;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="header-icon">
            <i data-lucide="shield-check" stroke-width="1.5" size="60"></i>
        </div>
        <h1> Student Marks Management</h1>
        <p>Database System v2.1.0</p>

        <div class="nav-menu">
            <a href="markadd.jsp" class="nav-item">
                <div class="icon-box"><i data-lucide="users"></i></div>
                <span>Add New Student</span>
            </a>

            <a href="DisplayMarkServlet" class="nav-item">
                <div class="icon-box"><i data-lucide="layout-list"></i></div>
                <span>Dashboard View</span>
            </a>

            <a href="markupdate.jsp" class="nav-item">
                <div class="icon-box"><i data-lucide="edit-3"></i></div>
                <span>Modify Data</span>
                <span class="admin-tag">Admin</span>
            </a>

            <a href="markdelete.jsp" class="nav-item">
                <div class="icon-box"><i data-lucide="trash-2"></i></div>
                <span>Remove Entry</span>
                <span class="admin-tag">Admin</span>
            </a>

           <a href="ReportServlet" class="nav-item">
               <div class="icon-box"><i data-lucide="file-text"></i></div>
               <span>Export Reports</span>
            </a>
        </div>
    </div>

    <script>
      lucide.createIcons();
    </script>
</body>
</html>