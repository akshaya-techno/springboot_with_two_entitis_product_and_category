/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */
// Write your code here
package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.*;
import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();

    Product addProduct(Product product);

    Product getProductById(int productId);

    Product updateProduct(int productId, Product product);

    Category getCategoryByProductId(int productId);

    void deleteProduct(int productId);
}