package com.example.demo.controller.interfaces;


import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryController {

    public Category updateCategoryItem(Long id, Category category);

    public Category saveCategoryItem(Category category);

    public List<Category> getAllCategoryItems();

    public Category getCategoryItemById(Long id);

    public String deleteCategoryItem(Long id);
}

