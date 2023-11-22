package com.example.demo.repository;


import com.example.demo.model.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void givenRecipe_whenSave_thenReturnSavedRecipe() {

        Recipe recipe = new Recipe("chicken", "cook well", "better.png", null);
        recipeRepository.save(recipe);

        Recipe savedRecipe = recipeRepository.save(recipe);

        assertThat(savedRecipe.getTitle()).isEqualTo("chicken");
    }

    @Test
    public void givenRecipe_whenFindById_thenReturnRecipe() {

        Recipe recipe = new Recipe("fish", "warm", "seafood.png", null);
        recipeRepository.save(recipe);

        Recipe item = recipeRepository.findById(recipe.getId()).get();

        assertThat(item.getTitle()).isEqualTo("fish");
    }

}