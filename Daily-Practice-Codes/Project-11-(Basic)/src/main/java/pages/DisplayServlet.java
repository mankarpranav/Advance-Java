package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init method");
	}

	public void destroy() {
		System.out.println("in destroy method..");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("DOB");
		String moto = request.getParameter("moto");
		int mobno= Integer.parseInt(request.getParameter("mobileno"));
		
		out.print("First Name of User: "+fname
				+"\nLast Name of User: "+lname
				+"\nDate of Birth: "+dob
				+"\nMOTO: "+moto
				+"\nMobile No:"+ mobno);
	}

}
