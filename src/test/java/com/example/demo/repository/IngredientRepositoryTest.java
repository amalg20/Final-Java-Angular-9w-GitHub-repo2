package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.model.Ingredient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    void givenIngredient_whenSave_thenReturnSavedIngredient() {

        Ingredient ingredient = new Ingredient("eggs", null);

        Ingredient savedOrder = ingredientRepository.save(ingredient);

        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getName()).isEqualTo("eggs");
    }

    @Test
    void givenSavedIngredient_whenFindById_thenReturnIngredient() {

        ingredientRepository.save(new Ingredient("eggs", null));

        Ingredient fetchedIngredient = ingredientRepository.findById(1L).get();

        assertThat(fetchedIngredient).isNotNull();
        assertThat(fetchedIngredient.getName()).isEqualTo("white sugar");
    }

    @Test
    void givenSavedIngredient_whenFindAll_thenReturnIngredient() {

        ingredientRepository.save(new Ingredient("eggs", null));
        ingredientRepository.save(new Ingredient("sugar", null));

        List<Ingredient> ingredientList = ingredientRepository.findAll();

        assertThat(ingredientList).hasSize(25);

    }

    @Test
    void givenSavedIngredient_whenUpdateStatus_thenIngredientShouldBeUpdated() {

        Ingredient savedIngredient = ingredientRepository.save(new Ingredient("eggs", null));

        savedIngredient.setName("sugar");
        ingredientRepository.save(savedIngredient);

        Ingredient updatedIngredient = ingredientRepository.findById(savedIngredient.getId()).get();

        assertThat(updatedIngredient.getName()).isEqualTo("sugar");
    }

    @Test
    void givenSavedIngredient_whenDeleteById_thenIngredientShouldBeDeleted() {

        Ingredient savedIngredient = ingredientRepository.save(new Ingredient("eggs", null));

        ingredientRepository.deleteById(savedIngredient.getId());

        Ingredient deletedIngredient = ingredientRepository.findById(savedIngredient.getId()).orElse(null);

        assertThat(deletedIngredient).isNull();
    }

}