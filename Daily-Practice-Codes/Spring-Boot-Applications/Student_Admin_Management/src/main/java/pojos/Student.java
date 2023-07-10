package pojos;

public class Student {
	public String firstName;
	public String lastName;
	public int score;
	public Course selectedCourse;
	public boolean admitted;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String firstName, String lastName, int score, Course selectedCourse) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
		this.selectedCourse = selectedCourse;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Course getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	public boolean isAdmitted() {
		return admitted;
	}
	public void setAdmitted(boolean admitted) {
		this.admitted = admitted;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + ", selectedCourse="
				+ selectedCourse + ", admitted=" + admitted + "]";
	}
	
}
