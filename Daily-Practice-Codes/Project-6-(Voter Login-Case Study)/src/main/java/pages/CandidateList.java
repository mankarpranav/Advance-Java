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
			
			//{
			//after cookie is added wala code
			//API of HttpServletRequest : Cookie[] getCookes()
			
			//returns null if no cookie is sent
			Cookie[] cookies=request.getCookies();
			if(cookies != null) {
				//how to retrieve data from cookie using getname and getvalue methods of cookie class
				
				Cookie[] cookies1 = request.getCookies(); // Get the cookies from the request

				if (cookies1 != null) {
				    for (Cookie c : cookies1) { //=> cookie are sent from the clnt
				    	//getName, getValue : 
				        if (c.getName().equals("user_dtls")) {
				            String cookieValue = c.getValue(); // Retrieve the value of the cookie
				           // Process the cookie value as needed
				           
				            pw.print("<h5>aaaaaValidated user details</h5> "+cookieValue);
				            
				            break; // Exit the loop since we found the desired cookie
				        }
				    }
				}

				
				
				
			}else {
				pw.print("<h5>Session tracking failed, no cookies!!!! Found!!!<h5>");
			}
			//}
			
			pw.print("<h5>In candidate list page ....</h5>");
			pw.print("<h5> Validated user details " + request.getParameter("em") + "</h5>");
			//in above line - output --> null
			//client submitted form
			//req resp loop got over
			//working with stateless protocol
			//every req is fresh req.
			//so everytime it is new req and thus
			//it shows null as it doesnt have anything store beforehand
			//and thus we are going to learn session in next lecture.
			
			
		}
	}

}

//when needed one time jobs to be done then write/override init() destroy() methods
//otherwise no need.

//ccokie class - 2methods --> 1.2.