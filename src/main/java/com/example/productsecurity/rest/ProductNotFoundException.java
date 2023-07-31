package com.example.productsecurity.rest;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer id) {
        super("Không tìm thấy sản phẩm có id: " + id);
    }
}
