package pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="FirstName",length=30,nullable=false)
	private String firstName;
	
	@Column(name="LastName",length=30,nullable=false)
	private String lastName;
	
	@Column(name="EmailID",length=30,nullable=false,unique = true)
	private String email;
	
	@Column(name="Password",length=30,nullable=false)
	private String password;
	
	@Column(name="Course",nullable=false)
	@Enumerated(EnumType.STRING)
	private Course course;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Student(String firstName, String lastName, String email, String password, Course course,
			LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.course = course;
		this.dob = dob;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", course=" + course + ", dob=" + dob + "]";
	}
	
}
