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
		
		try(SessionFactory retFactory = getFactory();
				Scanner sc=new Scanner(System.in)) {
			System.out.println("<------HIBERNATE WORKING SMOOTH------>");
			
			Employee emp = new Employee(sc.next(),
					sc.next(),
					sc.next(),
					sc.next(),
					LocalDate.parse(sc.next()),
					EmployeeType.valueOf(sc.next().toUpperCase()),
					sc.nextDouble());
			
			EmployeeDaoImpl obj = new EmployeeDaoImpl();
			obj.insertEmployee(emp);
			
		}catch(Exception e) {
			System.out.println("Message "+e);
		}
	}
}
