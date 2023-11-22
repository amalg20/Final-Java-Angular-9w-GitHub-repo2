package com.example.demo.service.interfaces;


import java.util.List;

import com.example.demo.model.Recipe;


public interface RecipeService {
    List<Recipe> getAllRecipes();

    Recipe getRecipeById(Long id);

    Recipe addRecipe(Recipe recipe);

    Recipe updateRecipeById(Long id, Recipe recipe);

    String deleteRecipe(Long id);
}
