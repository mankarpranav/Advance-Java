package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	private int laptopId;
	private String laptopName;

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public Laptop() {
		super();
	}

	public Laptop(int laptopId, String laptopName) {
		super();
		this.laptopId = laptopId;
		this.laptopName = laptopName;
	}

	// custom method
	public void compile() {
		System.out.println("compiling...");
	}

}
