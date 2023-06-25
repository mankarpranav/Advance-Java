package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private int id;
	private String name;

	// constructor
	Student() {
		System.out.println("In Student Constructor...");
	}

	// getter n setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
