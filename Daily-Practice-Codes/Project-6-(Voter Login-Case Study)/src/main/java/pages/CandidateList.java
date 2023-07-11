package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/candidate_list")
public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			// Cookie Retrieval
			Cookie[] cookies = request.getCookies(); // Get the cookies from the request
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("user_dtls")) {
						String cookieValue = c.getValue(); // Retrieve the value of the cookie
						pw.print("<h5>Validated user details: " + cookieValue + "</h5>");
						break; // Exit the loop since we found the desired cookie
					}
				}
			} else {
				pw.print("<h5>Session tracking failed, no cookies found!</h5>");
			}

			pw.print("<h5>In candidate list page ....</h5>");
			pw.print("<h5>Validated user details: " + request.getParameter("em") + "</h5>");
			// The above line shows null because it's a new request and no parameter named
			// "em" was passed in the request. We will learn about session tracking in the
			// next lecture.

		}
	}

}
