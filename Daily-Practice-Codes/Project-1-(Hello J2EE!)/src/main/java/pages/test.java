package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xyz")
public class test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Current Thread: "+Thread.currentThread());
		resp.setContentType("text/html");
		
		try(PrintWriter pw=resp.getWriter()){
			pw.print("<h1>Hello! To The World of J2EE!</h1>");
		}
	}

	@Override
	public void destroy() {
		System.out.println("in destroy... "+getClass());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init... "+getClass());
	}
}
