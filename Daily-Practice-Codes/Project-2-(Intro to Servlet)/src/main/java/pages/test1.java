package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page")
public class test1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try(PrintWriter pw = resp.getWriter()){
			pw.print("Here we come!");
		}
	}

	@Override
	public void destroy() {
		System.out.println("in destroy method of "+getClass());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init method of "+getClass());
	}
	
	
	
}
