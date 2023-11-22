package com.example.demo.service.interfaces;


import com.example.demo.model.Category;
import com.example.demo.model.Ingredient;

import java.util.List;


public interface IngredientService {
    List<Ingredient> getAllIngredientItems();

    Ingredient getIngredientItemById(Long id);

    Ingredient addIngredientItem(Ingredient ingredient);

    Ingredient updateIngredientItemById(Long id,Ingredient ingredient);

    String deleteIngredientItem(Long id);
}

