package com.example.demo.controller.imp;

import com.example.demo.controller.interfaces.ICategoryController;
import com.example.demo.controller.interfaces.IIngredientController;
import com.example.demo.model.Category;
import com.example.demo.model.Ingredient;
import com.example.demo.service.interfaces.CategoryService;
import com.example.demo.service.interfaces.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ingredient-items")
public class IngredientController implements IIngredientController {

    @Autowired
    private IngredientService ingredientService;

    //  ****************************************************  POST  ****************************************************
    @PostMapping("/")
    public Ingredient saveIngredientItem(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredientItem(ingredient);
    }

    //  ****************************************************  GET  ****************************************************
    @GetMapping("/")
    public List<Ingredient> getAllIngredientItems() {
        return ingredientService.getAllIngredientItems();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientItemById(@PathVariable("id") Long id) {
        return ingredientService.getIngredientItemById(id);
    }

    //  ****************************************************  PUT  ****************************************************
    @PutMapping("/{id}")
    public Ingredient updateIngredientItem(@PathVariable("id") Long id, @RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredientItemById(id, ingredient);
    }

    //  ****************************************************  DELETE  ****************************************************
    @DeleteMapping("/{id}")
    public String deleteIngredientItem(@PathVariable("id") Long id) {
        return ingredientService.deleteIngredientItem(id);
    }


}

