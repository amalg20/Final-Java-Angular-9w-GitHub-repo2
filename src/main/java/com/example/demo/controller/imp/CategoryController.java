package com.example.demo.controller.imp;



import com.example.demo.controller.interfaces.ICategoryController;

import com.example.demo.model.Category;
import com.example.demo.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/category-items")
public class CategoryController implements ICategoryController {

    @Autowired
    private CategoryService categoryService;

    //  ****************************************************  POST  ****************************************************
    @PostMapping("/")
    public Category saveCategoryItem(@RequestBody Category category) {
        return categoryService.addCategoryItem(category);
    }

    //  ****************************************************  GET  ****************************************************
    @GetMapping("/")
    public List<Category> getAllCategoryItems() {
        return categoryService.getAllCategoryItems();
    }

    @GetMapping("/{id}")
    public Category getCategoryItemById(@PathVariable("id") Long id) {
        return categoryService.getCategoryItemById(id);
    }

    //  ****************************************************  PUT  ****************************************************
    @PutMapping("/{id}")
    public Category updateCategoryItem(@PathVariable("id") Long id, @RequestBody Category category) {
        return categoryService.updateCategoryItemById(id, category);
    }

    //  ****************************************************  DELETE  ****************************************************
    @DeleteMapping("/{id}")
    public String deleteCategoryItem(@PathVariable("id") Long id) {
        return categoryService.deleteCategoryItem(id);
    }


}

