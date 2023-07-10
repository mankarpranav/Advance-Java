package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/Nav", loadOnStartup = 1)
public class FirstPage extends HttpServlet {

    // This method is called when the servlet is being initialized.
    @Override
    public void init() throws ServletException {
        System.out.println("In init of FirstPage!");
    }

    // This method is called when a GET request is made to the specified URL ("/Nav").
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the response content type to HTML.
        resp.setContentType("text/html");

        try (PrintWriter pw = resp.getWriter()) {
            // Send the HTML response containing a heading and a message to the client.
            pw.print("<h1>This is from inside of FirstPage!!!</h1><br><h3>Never Forget to make servlet class public; Otherwise 404 For Sure!!</h3>");
        }
    }

    // This method is called when the servlet is being destroyed.
    @Override
    public void destroy() {
        System.out.println("In destroy of FirstPage!");
    }
}
