package tester;

import java.util.List;
import java.util.Scanner;

import dao.StudentDaoImpl;
import pojos.Course;

public class TesterSpecificCourse {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			
			//dao instance
			StudentDaoImpl dao = new StudentDaoImpl();
			
			System.out.println("Enter Course: ");
			List<String> Students = dao.getStudentsFromSpecCourse(Course.valueOf(sc.next().toUpperCase()));
			System.out.println(Students);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
