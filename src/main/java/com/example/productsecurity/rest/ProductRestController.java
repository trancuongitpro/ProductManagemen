package com.example.productsecurity.rest;

import com.example.productsecurity.dao.ProductRepository;
import com.example.productsecurity.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductRepository repository;

    @Autowired
    public ProductRestController(ProductRepository theProductRepository) {
        repository = theProductRepository;
    }

    @GetMapping("/product")
    List<Product> all(){
        return repository.findAll();
    }

    @PostMapping("/product")
    Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @GetMapping("/product/{id}")
    Product one(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/product/{id}")
    Product updateEmp(@RequestBody Product updateProduct, @PathVariable Integer id) {
        return repository.findById(id)
                .map(product -> {
                    product.setProductName(updateProduct.getProductName());
                    product.setBrand(updateProduct.getBrand());
                    product.setPrice(updateProduct.getPrice());
                    product.setDescription(updateProduct.getDescription());
                    product.setQuantity(updateProduct.getQuantity());
                    return repository.save(product);
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @DeleteMapping("product/{id}")
    void deleteProduct(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/product/search")
    List<Product> getProductByName(@RequestParam("productName") String theProductName) {
        return repository.findProductByProductNameContainsIgnoreCase(theProductName);
    }
}
