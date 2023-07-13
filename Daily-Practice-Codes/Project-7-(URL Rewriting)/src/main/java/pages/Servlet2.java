package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve the value passed from the first servlet
		int num = Integer.parseInt(request.getParameter("k"));
		
		// Calculate the square of the number
		int square = num * num;
		
		// Get the PrintWriter object to write the response
		PrintWriter pw = response.getWriter();
		pw.print("\n\nSquare of number " + num + " after multiplication is: " + square);
		
		// Print a message to the console
		System.out.println("Here on Second Screen!!");
	}
}
