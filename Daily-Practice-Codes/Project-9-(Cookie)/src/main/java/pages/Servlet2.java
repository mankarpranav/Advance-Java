import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet2 is a servlet that performs a square calculation on a number received from a cookie.
 */
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Processes the HTTP GET and POST requests.
     *
     * @param request  the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get PrintWriter object to write response
        PrintWriter pw = response.getWriter();
        pw.print("in 2nd servlet..");

        int res = 0;

        // Retrieve cookies from the request
        Cookie[] cookies = request.getCookies();

        // Find the cookie with the name "result" and extract its value
        for (Cookie c : cookies) {
            if (c.getName().equals("result"))
                res = Integer.parseInt(c.getValue());
        }

        // Calculate the square of the number
        int square = res * res;

        // Get PrintWriter object to write the square value in the response
        PrintWriter pw1 = response.getWriter();
        pw1.print("\n\nSquare of number after multiplication is: " + square);
    }
}
