package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="abc")
public class Student {

	private String name;
	private int id;
	
	//creating reference of dependency
	@Autowired
	private Laptop laptop;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Student(String name, int id, Laptop laptop) {
		super();
		this.name = name;
		this.id = id;
		this.laptop = laptop;
	}

	public Student() {
		super();
	}
	
	public void show() {
		System.out.println("In show method()....");
		laptop.compile();                          //if Not @Autowired will raise NullPointerException	
	}

}
