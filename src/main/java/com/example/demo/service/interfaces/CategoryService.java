package com.example.demo.service.interfaces;


import java.util.List;


import com.example.demo.model.Category;



public interface CategoryService {
    List<Category> getAllCategoryItems();

    Category getCategoryItemById(Long id);

    Category addCategoryItem(Category menuItem);

    Category updateCategoryItemById(Long id,Category menuItem);

    String deleteCategoryItem(Long id);
}


