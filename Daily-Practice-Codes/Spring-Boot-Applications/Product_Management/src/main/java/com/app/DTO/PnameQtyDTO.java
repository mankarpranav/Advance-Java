package com.app.DTO;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PnameQtyDTO {
    @NotBlank(message = "pname must not be blank")
    private String pname; // Represents the product name
    
    @NotBlank(message = "Qty must not be blank")
    private int qty; // Represents the quantity of the product
}
