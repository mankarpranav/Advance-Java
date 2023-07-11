package com.pages;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Retrieving the values of "num1" and "num2" parameters from the request and parsing them as integers
        int a = Integer.parseInt(req.getParameter("num1"));
        int b = Integer.parseInt(req.getParameter("num2"));

        // Performing arithmetic operations
        int addition = a + b;
        int subtraction = a - b;
        int multiplication = a * b;
        int division = a / b;

        // Printing the results on the response
        resp.getWriter().println("Result of " + a + " + " + b + " is " + addition);
        resp.getWriter().println("Result of " + a + " - " + b + " is " + subtraction);
        resp.getWriter().println("Result of " + a + " * " + b + " is " + multiplication);
        resp.getWriter().println("Result of " + a + " / " + b + " is " + division);
    }
}
