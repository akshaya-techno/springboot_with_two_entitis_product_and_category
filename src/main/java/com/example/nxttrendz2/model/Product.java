/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.nxttrendz2.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Product() {
    }

    public Product(int productId, String productName, String description, double price) {
        this.id = productId;
        this.name = productName;
        this.description = description;
        this.price = price;
    }

    public void setProductId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return id;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return name;
    }

    public void setProductDescription(String description) {
        this.description = description;
    }

    public String getProductDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}