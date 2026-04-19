/*
 * Prime Number Servlet Program (Clean Version)
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    // If user opens servlet directly → redirect to form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }

    // Main logic
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String number = request.getParameter("num");

        // safety check
        if (number == null || number.isEmpty()) {
            response.sendRedirect("index.html");
            return;
        }

        int num = Integer.parseInt(number);

        boolean isPrime = true;

        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        out.println("<html><body>");
        out.println("<h2>Prime Number Result</h2>");

        if (isPrime) {
            out.println("<h3>" + num + " is a PRIME number</h3>");
        } else {
            out.println("<h3>" + num + " is NOT a PRIME number</h3>");
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}