package pages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));
		int result = a+b;
		
		//Can we call servlet from another servlet ?? YES
		//using two ways -
		
		//1.Request Dispatcher and 2.Redirect
		
		//to send value we can send by-
		//1.setting attribute in responce object
		//2.by using session management
		
		request.setAttribute("result",result);		//sending in key and value format
		
		//creating object of RequestDispatcher which is an interface,
		//create object sing getRequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("sq"); 
		rd.forward(request, response);
	}
}
