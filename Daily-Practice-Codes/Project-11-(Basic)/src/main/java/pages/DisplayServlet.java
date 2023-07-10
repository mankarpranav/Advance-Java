package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // This method is called when the servlet is being initialized.
    public void init(ServletConfig config) throws ServletException {
        System.out.println("In init method");
    }

    // This method is called when the servlet is being destroyed.
    public void destroy() {
        System.out.println("In destroy method..");
    }

    // This method is called when a GET request is made to the specified URL ("/DisplayServlet").
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // Retrieve the parameter values from the request.
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dob = request.getParameter("DOB");
        String moto = request.getParameter("moto");
        int mobno = Integer.parseInt(request.getParameter("mobileno"));

        // Print the retrieved values to the response.
        out.print("First Name of User: " + fname
                + "\nLast Name of User: " + lname
                + "\nDate of Birth: " + dob
                + "\nMOTO: " + moto
                + "\nMobile No: " + mobno);
    }
}
