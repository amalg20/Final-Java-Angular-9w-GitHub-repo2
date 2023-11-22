package com.example.demo.service.impl;


import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;




@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategoryItems() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryItemById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category addCategoryItem(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategoryItemById(Long id, Category category) {
        categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        category.setId(id);

        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategoryItem(Long id) {

        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "Category deleted successfully";
        }
        return "No such Category in the database";
    }

}

