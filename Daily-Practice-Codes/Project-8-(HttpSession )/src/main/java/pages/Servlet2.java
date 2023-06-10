package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter() ;
		pw.print("in 2nd servlet..");
		
		//Now, we will get session and perform operations as we want.
		
		HttpSession session = request.getSession();
		
		int res =(int)(session.getAttribute("result")); 	
		
		int square = res*res;
		
		PrintWriter pw1 = response.getWriter();
		pw1.print("\n\nSquare of number after multiplication is :"+square);
	}
}
