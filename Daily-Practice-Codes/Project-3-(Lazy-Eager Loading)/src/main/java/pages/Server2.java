package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jump2") // This servlet will load lazily on the first request to the URL ("/jump2")
public class Server2 extends HttpServlet {

    // This method is called when a GET request is made to the specified URL ("/jump2").
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the response content type to HTML.
        resp.setContentType("text/html");
        
        try (PrintWriter pw = resp.getWriter()) {
            // Send the response containing the message to the client.
            pw.print("Jumped from index.html to Server2's doGet()...");
        }
    }

    // This method is called when the servlet is being destroyed.
    @Override
    public void destroy() {
        System.out.println("In destroy of Server2...");
    }

    // This method is called when the servlet is being initialized.
    @Override
    public void init() throws ServletException {
        System.out.println("In init of Server2...");
    }

}
