package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page")
public class Test1Servlet extends HttpServlet {

    // This method is called when a GET request is made to the specified URL ("/page").
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the response content type to HTML.
        resp.setContentType("text/html");
        
        try (PrintWriter pw = resp.getWriter()) {
            // Send the response containing the message to the client.
            pw.print("Here we come!");
        }
    }

    // This method is called when the servlet is being destroyed.
    @Override
    public void destroy() {
        System.out.println("In destroy method of " + getClass());
    }

    // This method is called when the servlet is being initialized.
    @Override
    public void init() throws ServletException {
        System.out.println("In init method of " + getClass());
    }
}
