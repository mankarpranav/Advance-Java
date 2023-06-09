package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter() ;
		pw.print("in 2nd servlet..");
		
		//Fetching value which is fetched from servlet1
		
		int num = (int) request.getAttribute("result");
		int square = num*num;
		
		PrintWriter pw1 = response.getWriter();
		pw1.print("\n\nSquare of number after multiplication is :"+square);
	}
}
