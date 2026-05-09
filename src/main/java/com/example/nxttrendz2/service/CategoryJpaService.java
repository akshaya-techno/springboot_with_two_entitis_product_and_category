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

import java.util.*;

import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.CategoryRepository;
import com.example.nxttrendz2.model.*;

@Service
public class CategoryJpaService implements CategoryRepository {

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public List<Category> getCategories() {
        List<Category> categoryList = categoryJpaRepository.findAll();
        return new ArrayList<>(categoryList);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryJpaRepository.save(category);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryJpaRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Category updateCategory(int categoryId, Category category) {
        Category existingCategory = getCategoryById(categoryId);

        if (category.getName() != null) {
            existingCategory.setName(category.getName());
        }
        if (category.getDescription() != null) {
            existingCategory.setDescription(category.getDescription());
        }

        return categoryJpaRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(int categoryId) {
<<<<<<< HEAD

        Category category = getCategoryById(categoryId);
        categoryJpaRepository.delete(category);
=======
        
            Category category = categoryJpaRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            categoryJpaRepository.delete(category);
        
>>>>>>> before final commit 5

    }
}

