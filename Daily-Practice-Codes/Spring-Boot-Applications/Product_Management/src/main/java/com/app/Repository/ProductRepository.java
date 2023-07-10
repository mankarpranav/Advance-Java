package com.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query method to find a product by its name and quantity
    Optional<Product> findByPnameAndQty(String pname, int qty);
}
