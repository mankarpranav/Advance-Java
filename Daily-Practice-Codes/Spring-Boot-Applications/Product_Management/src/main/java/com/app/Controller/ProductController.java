package com.app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.PnameQtyDTO;
import com.app.DTO.ResponseDTO;
import com.app.Service.ProductServiceImpl;
import com.app.entities.Product;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	private ProductServiceImpl pser;

	// Constructor
	public ProductController() {
		// TODO Auto-generated constructor stub
	}

	// API to insert a product
	@PostMapping("/add")
	public Product insertProduct(@RequestBody Product p) {
		return pser.InsertProduct(p);
	}

	// API to get the list of products
	@GetMapping("/plist")
	public List<Product> getProductList() {
		return pser.getProductList();
	}

	// API to delete a product by its id
	@GetMapping("/delete/{id}")
	public ResponseDTO deleteProductById(@PathVariable long id) {
		return new ResponseDTO(pser.deleteProductById(id));
	}

	// API to get a product by its id
	@GetMapping("/update/{id}")
	public ResponseEntity<?> getProductById(@PathVariable long id) {
		return new ResponseEntity<>(pser.getProductById(id), HttpStatus.ACCEPTED);
	}

	// API to update a product
	@PostMapping("/update/product")
	public ResponseEntity<?> updateProduct(@RequestBody Product p) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pser.insertProduct(p));
	}

	// API to validate a product
	@PostMapping("/signin")
	public ResponseEntity<?> validateProduct(@RequestBody PnameQtyDTO p) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pser.validate(p));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(e.getMessage()));
		}
	}
}
