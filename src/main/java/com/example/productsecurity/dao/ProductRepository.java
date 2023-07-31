package com.example.productsecurity.dao;

import com.example.productsecurity.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByOrderByProductNameAsc();

    public List<Product> findProductByProductNameContainsIgnoreCase(String productName);
}
