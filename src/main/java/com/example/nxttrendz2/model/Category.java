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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Category() {
    }

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setCategoryId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return id;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return name;
    }

    public void setCategoryDescription(String description) {
        this.description = description;
    }

    public String getCategoryDescription() {
        return description;
    }
}