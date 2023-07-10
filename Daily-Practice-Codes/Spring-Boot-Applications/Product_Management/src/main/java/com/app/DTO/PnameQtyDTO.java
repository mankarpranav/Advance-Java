package com.app.DTO;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PnameQtyDTO {
	@NotBlank(message = "pname not be blank")	
	private String pname;
	@NotBlank(message = "Qty not be blank")
	private int qty;
}
