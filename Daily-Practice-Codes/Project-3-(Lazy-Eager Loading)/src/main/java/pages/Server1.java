package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/jump1", loadOnStartup = 1) // This servlet will load eagerly on application startup
public class Server1 extends HttpServlet {

    // This method is called when a GET request is made to the specified URL ("/jump1").
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the response content type to HTML.
        resp.setContentType("text/html");
        
        try (PrintWriter pw = resp.getWriter()) {
            // Send the response containing the message to the client.
            pw.print("Jumped from index.html to Server1's doGet()...");
        }
    }

    // This method is called when the servlet is being destroyed.
    @Override
    public void destroy() {
        System.out.println("In destroy of Server1...");
    }

    // This method is called when the servlet is being initialized.
    @Override
    public void init() throws ServletException {
        System.out.println("In init of Server1...");
    }
}
