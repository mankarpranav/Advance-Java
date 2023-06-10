package pages;

import java.io.IOException;

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
		
		//1.Request Dispatcher and
		//2.Redirect
		
		//Firstly we will send request to servlet1 and it will say that 
		//you just redirect to the servlet2 .
		
		//cause this error -> java.lang.NumberFormatException: null
//		java.base/java.lang.Integer.parseInt(Integer.java:614)
//		java.base/java.lang.Integer.parseInt(Integer.java:770)
//		pages.Servlet2.service(Servlet2.java:20)
//		javax.servlet.http.HttpServlet.service(HttpServlet.java:741)
//		org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
		
		//as it is saying number format exception,
		//if we change url then it works and this way of "url writing" can be used to resolve this issue.
		//as second servlet was asking for data.
		//http://localhost:8080/Project-u/sq?k=2 :     gives output=> 4
		
		//changing here -- from this to
//		response.sendRedirect("sq");
		
		response.sendRedirect("sq?k="+result);
	}
}
