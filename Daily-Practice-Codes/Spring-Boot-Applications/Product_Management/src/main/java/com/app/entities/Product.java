package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity {
	@Column(length = 20, unique = true)
	private String pname;
	@Column(nullable = false)
	private int qty;
	@Column(nullable = false)
	private double price;
	@Column(length = 30)
	private String description;

	private String imgpath;
	
	public Product() {

	}

	public Product(String pname, int qty, double price, String description) {
		super();
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [pname=" + pname + ", qty=" + qty + ", price=" + price + ", description=" + description + "]";
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
