/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxttrendz2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxttrendz2.model.*;
import com.example.nxttrendz2.repository.*;


import java.util.*;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public List<Product> getProducts() {
        List<Product> productList = productJpaRepository.findAll();
        return new ArrayList<>(productList);
    }

    @Override
    public Product addProduct(Product product) {
        if (product.getCategory() != null) {
            int categoryId = product.getCategory().getCategoryId();
            Category category = categoryJpaRepository.findById(categoryId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            product.setCategory(category);
        }

        return productJpaRepository.save(product);
    }

    @Override
    public Product getProductById(int productId) {
        return productJpaRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product existingProduct = getProductById(productId);

        if (product.getProductName() != null) {
            existingProduct.setProductName(product.getProductName());
        }
        if (product.getProductDescription() != null) {
            existingProduct.setProductDescription(product.getProductDescription());
        }
        if (product.getPrice() != 0) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getCategory() != null) {
            int categoryId = product.getCategory().getCategoryId();
            Category category = categoryJpaRepository.findById(categoryId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            existingProduct.setCategory(category);
        }

        return productJpaRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(int productId) {
        Product product = getProductById(productId);
        productJpaRepository.delete(product);
    }

    @Override
    public Category getCategoryByProductId(int productId) {
            Product product = getProductById(productId);
            int categoryId = product.getCategory().getCategoryId();
            Category category = categoryJpaRepository.findById(categoryId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            return category;
    }

}