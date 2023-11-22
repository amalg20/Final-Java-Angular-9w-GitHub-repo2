package com.example.demo.controller.interfaces;


import com.example.demo.model.Recipe;

import java.util.List;

public interface IRecipeController {
    //    Write here the signatures of the controller methods
    public Recipe saveRecipe(Recipe recipe);

    public List<Recipe> getAllRecipes();

    public Recipe getRecipeById(Long id);

    public Recipe updateRecipe(Long id, Recipe recipe);

    public String deleteRecipe(Long id);
}



