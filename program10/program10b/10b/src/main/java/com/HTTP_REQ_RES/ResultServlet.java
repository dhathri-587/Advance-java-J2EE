package com.HTTP_REQ_RES;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/processResult")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String studentName = request.getParameter("studentname");

        // Get subject marks
        int[] marks = new int[5];
        String[] subjects = {"sub1", "sub2", "sub3", "sub4", "sub5"};
        boolean valid = true;

        for (int i = 0; i < 5; i++) {
            try {
                marks[i] = Integer.parseInt(request.getParameter(subjects[i]));
                if (marks[i] < 0 || marks[i] > 100) {
                    valid = false;
                }
            } catch (NumberFormatException e) {
                valid = false;
            }
        }

        String message;
        if (rollno == null || rollno.trim().isEmpty() ||
            studentName == null || studentName.trim().isEmpty() || !valid) {
            message = "Invalid input. Please enter valid Roll No, Name, and marks (0-100).";
        } else {
            // Calculate average
            int total = 0;
            for (int m : marks) total += m;
            double average = total / 5.0;

            // Check pass/fail (all subjects > 40)
            boolean pass = true;
            for (int m : marks) {
                if (m <= 40) {
                    pass = false;
                    break;
                }
            }

            message = pass ? "Result: PASS" : "Result: FAIL";

            // Set attributes
            request.setAttribute("rollno", rollno);
            request.setAttribute("studentname", studentName);
            request.setAttribute("marks", marks);
            request.setAttribute("average", average);
        }

        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
