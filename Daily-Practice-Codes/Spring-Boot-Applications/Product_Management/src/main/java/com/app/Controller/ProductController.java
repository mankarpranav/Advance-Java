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

	public ProductController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/add")
	public Product insertProduct(@RequestBody Product p) {
		return pser.InsertProduct(p);
	}

	@GetMapping("/plist")
	public List<Product> GetProductList() {
		return pser.GetProductList();

	}

	@GetMapping("/delete/{id}")
	public ResponseDTO DeleteProductById(@PathVariable long id) {
		return new ResponseDTO(pser.DeleteProductById(id));
	}

	@GetMapping("/update/{id}")
	public ResponseEntity<?> Getproductbyid(@PathVariable long id) {
		return new ResponseEntity<>(pser.Getproductbyid(id), HttpStatus.ACCEPTED);
	}

	@PostMapping("/update/product")
	public ResponseEntity<?> insertit(@RequestBody Product p) {

		return ResponseEntity.status(HttpStatus.CREATED).body(pser.InsertProduct(p));
	}

	@GetMapping("/signin")
	public ResponseEntity<?> Validateproduct(@RequestBody PnameQtyDTO p) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pser.validate(p));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(e.getMessage()));

		}

	}

//	@GetMapping("/update")
//	public Product UpdateProduct(@RequestBody Product p) {
//		return pser.UpdateProduct(p);
//	}

//	@PostMapping("/delete")
//	public void DeleteProduct(@RequestBody Product p) {
//		pser.DeleteProduct(p);
//	}

//	@GetMapping("/update/{id}")
//	public Product UpdateProductById(@PathVariable Long id) {
//		return pser.UpdateProductById(id);
//	}

//	@GetMapping("/delete/{id}")
//	public void DeleteProductById(@PathVariable long id) {
//		pser.DeleteProductById(id);
//	}
}
