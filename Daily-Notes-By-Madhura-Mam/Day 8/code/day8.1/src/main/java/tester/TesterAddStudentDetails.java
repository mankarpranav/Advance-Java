package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class TesterAddStudentDetails {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
				
		//create dao instance
		StudentDaoImpl obj = new StudentDaoImpl();
		
		//print
		System.out.println("Insert- (firstName, lastName, email, password, course, dob) ");
		
		//create student instance to insert 
		Student student = new Student(sc.next(),sc.next(),sc.next(),sc.next(),Course.valueOf(sc.next().toUpperCase()),
				LocalDate.parse(sc.next()));
		
		//pass that new instance to method to insert
		obj.registration(student);
			
		}catch(RuntimeException ex){
			throw ex;
		}
	}

}
