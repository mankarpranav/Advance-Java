package pojos;

public class Student {
    private String firstName;
    private String lastName;
    private int score;
    private Course selectedCourse;
    private boolean admitted;

    public Student() {
        // Default constructor
    }

    public Student(String firstName, String lastName, int score, Course selectedCourse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.selectedCourse = selectedCourse;
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
