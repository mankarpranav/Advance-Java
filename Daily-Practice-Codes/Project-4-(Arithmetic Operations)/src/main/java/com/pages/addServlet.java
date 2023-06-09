package com.pages;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		int a = Integer.parseInt(req.getParameter("num1"));
		int b = Integer.parseInt(req.getParameter("num2"));
		
		int addition = a+b;
		int substraction = a-b;
		int multiplication = a*b;
		int division = a/b;
		//System.out.println("Result is : "+ result);
		//This will print on console.
		
		//We want to Print result on screen
		//getWriter() throws exception to handle that we will put that in try block or delegate to the caller
		
		resp.getWriter().println("result is of "+a+" + "+b+" is "+ addition);
		resp.getWriter().println("result is of "+a+" - "+b+" is "+ substraction);
		resp.getWriter().println("result is of "+a+" * "+b+" is "+ multiplication);
		resp.getWriter().println("result is of "+a+" / "+b+" is "+ division);
		
	} 
}
