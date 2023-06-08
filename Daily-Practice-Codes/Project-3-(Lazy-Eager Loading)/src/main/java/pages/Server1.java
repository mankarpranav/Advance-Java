package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/jump1",loadOnStartup = 1)			//will load eagerly
public class Server1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try(PrintWriter pw = resp.getWriter()){
			pw.print("jumped from index.html to server1 doGet()...");
		}
	}

	@Override
	public void destroy() {
		System.out.println("in destroy of server1...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init of server1...");
	}
	
	
	
	
}
