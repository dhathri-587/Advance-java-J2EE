package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("uname");

        HttpSession session = request.getSession();
        session.setAttribute("username", name);

        // 1 minute expiry
        session.setMaxInactiveInterval(60);

        response.sendRedirect("welcome.jsp");
    }
}