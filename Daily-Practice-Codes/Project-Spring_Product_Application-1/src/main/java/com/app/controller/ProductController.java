package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ProductService;
import com.example.pojos.Product;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {
    @Autowired
    private ProductService prodService;

    public ProductController() {
        System.out.println("In ProductController constructor");
    }

    @GetMapping
    public List<Product> getAllProducts() {
        System.out.println("Inside getAllProducts method");
        return prodService.listOfProducts();
    }
}
