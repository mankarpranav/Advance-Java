package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));
		int result = a+b;
		
		//Cookie --> Using Cookie to interact and send value across multiple 
		//servlets
		
		//here second argument should be string.
		//and that the limitation of cookies
		
		Cookie cookie = new Cookie("result",result+"");
		
		//attaching the cookie and sending the responce back.
		response.addCookie(cookie);
		
		//jumping back to square servlet		
		response.sendRedirect("sq");
	}
}
