package com.example.demo;

import org.springframework.stereotype.Component;

@Component(value = "Student")
public class Student {

	private int studid;
	private String name;

	// constructors
	public Student(int studid, String name) {
		super();
		this.studid = studid;
		this.name = name;
	}

	public Student() {
		super();
		System.out.println("In constructor of Student");
	}

	// setters n getters
	public int getStudid() {
		return studid;
	}

	public void setStudid(int studid) {
		this.studid = studid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("In show method..of student");
	}

}
