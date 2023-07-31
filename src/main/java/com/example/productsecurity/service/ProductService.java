package com.example.productsecurity.service;

import com.example.productsecurity.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(int theId);
    public void save(Product theProduct);
    public void deleteById(int theId);
    public List<Product> searchByProductName(String theProductName);
}
