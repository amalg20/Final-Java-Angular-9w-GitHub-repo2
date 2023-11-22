package com.example.demo.service.impl;


import com.example.demo.model.Ingredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.service.interfaces.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAllIngredientItems() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredientItemById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public Ingredient addIngredientItem(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateIngredientItemById(Long id, Ingredient ingredient) {
        ingredientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        ingredient.setId(id);

        return ingredientRepository.save(ingredient);
    }

    @Override
    public String deleteIngredientItem(Long id) {

        if (ingredientRepository.findById(id).isPresent()) {
            ingredientRepository.deleteById(id);
            return "Ingredient deleted successfully";
        }
        return "No such Ingredient in the database";
    }

}

