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
//		PrintWriter pw = response.getWriter() ;
//		pw.print("in 2nd servlet..");
//		
//		//now wc will redirect here at servlet2
//		
		int num = Integer.parseInt(request.getParameter("k"));
		int square = num*num;
		
		PrintWriter pw1 = response.getWriter();
		pw1.print("\n\nSquare of number "+num+" after multiplication is :"+square);
	
		System.out.println("Here on Second Screen!!");
	}
}
