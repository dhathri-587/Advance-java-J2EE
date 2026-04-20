package com.cookie;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("username");
        Cookie[] cookies = request.getCookies();
        
        String userName = "";
        int count = 0;

        // Search for existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("userCookie")) {
                    userName = c.getValue();
                }
                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // If it's a new submission from HTML, use the parameter
        if (name != null) {
            userName = name;
        }

        count++; // Increment visit count

        // Create/Update Cookies
        Cookie c1 = new Cookie("userCookie", userName);
        Cookie c2 = new Cookie("visitCount", String.valueOf(count));

        // Demonstrate Expiry: Set to 60 seconds
        c1.setMaxAge(60); 
        c2.setMaxAge(60);

        // Add cookies to response
        response.addCookie(c1);
        response.addCookie(c2);

        // Display Output
        out.println("<html><body>");
        out.println("<h2>Welcome back, " + userName + "!</h2>");
        out.println("<h3>You have visited this page " + count + " time(s).</h3>");
        
        out.println("<h4>Current Cookies in Browser:</h4>");
        out.println("<table border='1'><tr><th>Cookie Name</th><th>Value</th></tr>");
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
            }
        }
        out.println("</table>");

        out.println("<p><a href='CookieServlet'>Refresh Page (Visit Again)</a></p>");
        out.println("<p><i>Note: Cookies will expire in 60 seconds of inactivity.</i></p>");
        out.println("</body></html>");
    }
}