package com.cookieservlet;

// Step 1: Import packages
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

// Step 2: Create servlet
@WebServlet("/CookieServlet")

public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Step 3: Handle GET request
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Step 4: Create cookies
        if (userName != null && !userName.isEmpty()) {

            Cookie nameCookie = new Cookie("user", userName);
            Cookie countCookie = new Cookie("visitCount", "1");

            // Step 5: Set expiry (30 seconds)
            nameCookie.setMaxAge(30);
            countCookie.setMaxAge(30);

            response.addCookie(nameCookie);
            response.addCookie(countCookie);
        }

        // Step 6: Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }

                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;

                    // Update count cookie
                    Cookie updatedCookie = new Cookie("visitCount", String.valueOf(visitCount));
                    updatedCookie.setMaxAge(30);
                    response.addCookie(updatedCookie);
                }
            }
        }

        // Step 7: Display Output
        out.println("<html><body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:green;'>You have visited this page " + visitCount + " times!</h2>");

            // Step 8: Display all cookies
            out.println("<h3>Cookies List:</h3>");
            if (cookies != null) {
                for (Cookie c : cookies) {
                    out.println("Name: " + c.getName() + " | Value: " + c.getValue() + "<br>");
                }
            }

        } else {
            out.println("<h2 style='color:red;'>First Visit! Please enter your name.</h2>");
            out.println("<a href='index.html'>Go Back</a>");
        }

        out.println("</body></html>");
    }
}
