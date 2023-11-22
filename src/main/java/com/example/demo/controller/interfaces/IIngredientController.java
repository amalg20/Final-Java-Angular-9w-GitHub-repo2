package com.example.demo.controller.interfaces;


import com.example.demo.model.Ingredient;

import java.util.List;

public interface IIngredientController {

    public Ingredient updateIngredientItem(Long id, Ingredient ingredient);

    public Ingredient saveIngredientItem(Ingredient ingredient);

    public List<Ingredient> getAllIngredientItems();

    public Ingredient getIngredientItemById(Long id);

    public String deleteIngredientItem(Long id);
}

