package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        // Server-Sided Validation
        if (username == null || username.trim().isEmpty() || 
            email == null || !email.contains("@") || 
            designation == null || designation.trim().isEmpty()) {
            
            response.sendRedirect("index.jsp?error=InvalidInput");
        } else {
            // Pass data to the result page
            request.setAttribute("uName", username);
            request.setAttribute("uEmail", email);
            request.setAttribute("uDesig", designation);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}