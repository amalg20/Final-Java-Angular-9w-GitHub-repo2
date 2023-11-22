package com.example.demo.controller.imp;


import com.example.demo.model.Recipe;
import com.example.demo.service.interfaces.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;


    //  ****************************************************  GET  ****************************************************
    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes(@RequestParam(required = false) String title) {
        try {
            List<Recipe> recipes = new ArrayList<Recipe>();

            recipes = recipeService.getAllRecipes();

            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@PathVariable("id") Long id) {
        return recipeService.getRecipeById(id);
    }

    //  ****************************************************  POST  ****************************************************
    @PostMapping("/recipes")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        try {

            Recipe recipe1 = recipeService.addRecipe(recipe);

            return new ResponseEntity<>(recipe1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //  ****************************************************  PUT  ****************************************************
    @PutMapping("/recipes/{id}")
    public Recipe updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipeById(id, recipe);
    }

    //  ****************************************************  DELETE  ****************************************************
    @DeleteMapping("/recipes/{id}")
    public String deleteRecipe(@PathVariable("id") Long id) {
        return recipeService.deleteRecipe(id);
    }
}



