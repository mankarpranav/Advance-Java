package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extract the values of the submitted numbers
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));
		
		// Perform the addition operation
		int result = a + b;
		
		// Use session management to store the result value
		HttpSession session = request.getSession();
		session.setAttribute("result", result);
		
		// Redirect the response to another servlet named "sq"
		response.sendRedirect("sq");
	}
}
