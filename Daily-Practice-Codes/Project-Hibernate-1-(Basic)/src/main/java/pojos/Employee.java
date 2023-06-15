package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EmployeeTable")
public class Employee {
	
	/*
	 * emp_id(PK) ,first_name,last_name,email(unique),password,join_date,
	 * emp_type(full_time/part_time/contract...) salary
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empID;
	
	@Column(name="FirstName",length=30)
	private String fname;
	
	@Column(name="LastName",length=30)
	private String lname;
	
	@Column(name="EmailAddress",length=30)
	private String email;
	
	@Column(name="Password",length=30,nullable=false)
	private String password;
	
	@Column(name="JoiningDate")
	private LocalDate joinDate;
	
	@Column(name="TypeofContract")
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
	@Column(name="Salary")
	private double salary;
	
	public Employee(String fname, String lname, String email, String password, LocalDate joinDate,
			EmployeeType type, double salary) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.type = type;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", joinDate="
				+ joinDate + ", type=" + type + ", salary=" + salary + "]";
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
