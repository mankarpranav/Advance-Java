package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Student class represents a student entity.
 */
@Component(value = "Student")
public class Student {

    private int studId;
    private String name;

    /**
     * Constructor to create a Student object with provided student ID and name.
     *
     * @param studId The ID of the student.
     * @param name   The name of the student.
     */
    public Student(int studId, String name) {
        super();
        this.studId = studId;
        this.name = name;
    }

    /**
     * Default constructor for Student class.
     */
    public Student() {
        super();
        System.out.println("In constructor of Student");
    }

    /**
     * Get the student ID.
     *
     * @return The student ID.
     */
    public int getStudId() {
        return studId;
    }

    /**
     * Set the student ID.
     *
     * @param studId The student ID to set.
     */
    public void setStudId(int studId) {
        this.studId = studId;
    }

    /**
     * Get the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the student.
     *
     * @param name The name of the student to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to show information about the student.
     */
    public void show() {
        System.out.println("In show method of Student");
    }

}
