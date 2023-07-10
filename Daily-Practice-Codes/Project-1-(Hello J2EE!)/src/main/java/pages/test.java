package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xyz")
public class TestServlet extends HttpServlet {

    // This method is called when a GET request is made to the specified URL ("/xyz").
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Print the current thread information to the console.
        System.out.println("Current Thread: " + Thread.currentThread());

        // Set the response content type to HTML.
        resp.setContentType("text/html");

        try (PrintWriter pw = resp.getWriter()) {
            // Send the HTML response containing a heading to the client.
            pw.print("<h1>Hello! Welcome to the World of J2EE!</h1>");
        }
    }

    // This method is called when the servlet is being destroyed.
    @Override
    public void destroy() {
        System.out.println("In destroy... " + getClass());
    }

    // This method is called when the servlet is being initialized.
    @Override
    public void init() throws ServletException {
        System.out.println("In init... " + getClass());
    }
}
