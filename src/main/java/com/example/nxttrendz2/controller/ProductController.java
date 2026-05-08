/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.nxttrendz2.service.ProductJpaService;
import com.example.nxttrendz2.model.*;

@RestController

public class ProductController {
    @Autowired
    private ProductJpaService productJpaService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productJpaService.getProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productJpaService.addProduct(product);
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productJpaService.getProductById(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        return productJpaService.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productJpaService.deleteProduct(productId);
    }

    @GetMapping("/products/{productId}/category")
    public Category getCategoryByProductId(@PathVariable int productId) {
        return productJpaService.getCategoryByProductId(productId);
    }

}
