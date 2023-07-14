package tester;

import static utils.HBUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmployeeType;

public class Test {

    public static void main(String[] args) {
        try (SessionFactory retFactory = getFactory(); Scanner sc = new Scanner(System.in)) {
            System.out.println("<------HIBERNATE WORKING SMOOTH------>");

            // Prompt user to enter employee details
            System.out.print("Enter First Name: ");
            String fname = sc.next();

            System.out.print("Enter Last Name: ");
            String lname = sc.next();

            System.out.print("Enter Email: ");
            String email = sc.next();

            System.out.print("Enter Password: ");
            String password = sc.next();

            System.out.print("Enter Joining Date (yyyy-mm-dd): ");
            LocalDate joinDate = LocalDate.parse(sc.next());

            System.out.print("Enter Employee Type (FULLTIME/PARTTIME/INTERN): ");
            EmployeeType type = EmployeeType.valueOf(sc.next().toUpperCase());

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            // Create an employee object
            Employee emp = new Employee(fname, lname, email, password, joinDate, type, salary);

            // Insert the employee into the database
            EmployeeDaoImpl obj = new EmployeeDaoImpl();
            obj.insertEmployee(emp);
        } catch (Exception e) {
            System.out.println("Message " + e);
        }
    }
}
