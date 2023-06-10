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
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));
		int result = a+b;
		
		//to send value we can send by-
		//1.setting attribute in responce object
		//2.by using session management
		
		//Here using session management..
		//creating object of HTTPSession which is actually interface 
		//so creating object of class implementing HttpSession interface
		
		HttpSession session = request.getSession();
		
		//setting attributes in the form of key and value pair.
		session.setAttribute("result",result);
		
		response.sendRedirect("sq");
	}
}
