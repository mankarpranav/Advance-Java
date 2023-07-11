package pages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int a = Integer.parseInt(request.getParameter("num1"));
        int b = Integer.parseInt(request.getParameter("num2"));
        int result = a + b;

        // We can call a servlet from another servlet using two ways:
        // 1. Request Dispatcher
        // 2. Redirect

        // To send values between servlets, we can use:
        // 1. Setting attribute in the response object
        // 2. Session management

        request.setAttribute("result", result); // Sending the result value as an attribute

        // Creating an object of RequestDispatcher which is an interface,
        // obtained using getRequestDispatcher
        RequestDispatcher rd = request.getRequestDispatcher("sq");
        rd.forward(request, response);
    }
}
