package com.example.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prod1")
public class Product extends BaseEntity {
    @Column(length = 30)
    private String pname;

    private int quantity;

    private int price;

    @Column(length = 30)
    private String description;

    public Product() {
        super();
        System.out.println("In Product constructor");
    }

    public Product(String pname, int quantity, int price, String description) {
        super();
        this.pname = pname;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [pname=" + pname + ", quantity=" + quantity + ", price=" + price + ", description="
                + description + "]";
    }
}
