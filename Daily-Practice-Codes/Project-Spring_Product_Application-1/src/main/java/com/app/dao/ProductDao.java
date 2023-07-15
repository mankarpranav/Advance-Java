package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojos.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
