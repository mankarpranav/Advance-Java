package com.app.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseIdPnamePrice {
    private String pname; // Represents the product name
    private int qty; // Represents the quantity of the product
    private double price; // Represents the price of the product
}
