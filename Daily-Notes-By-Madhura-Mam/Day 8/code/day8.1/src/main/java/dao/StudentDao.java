package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface StudentDao {
	
	//add student
	public void registration(Student student);
	
	//student login
	public String studentLogin(String email,String password);
	
	//get all student details from specific course
	public List<String> getStudentsFromSpecCourse(Course course);
	
}
