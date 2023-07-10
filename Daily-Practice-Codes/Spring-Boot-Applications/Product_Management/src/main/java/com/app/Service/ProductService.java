package com.app.Service;

import java.util.List;

import com.app.entities.Product;

public interface ProductService {

	Product InsertProduct(Product p);

	List<Product> GetProductList();

	Product UpdateProduct(Product p);

	Product UpdateProductById(long id);

	void DeleteProduct(Product p);

	
	
	
	String DeleteProductById(long id);
	
	Product Getproductbyid(long id);
}
