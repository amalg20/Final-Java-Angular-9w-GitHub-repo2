package com.example.demo.controller.imp;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IngredientRepository ingredientRepository;


    @Autowired
    WebApplicationContext webApplicationContext;
    Ingredient ingredient;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        ingredient = new Ingredient("apple", null);
    }


    @Test
    void saveIngredientItem_validBody() throws Exception {
        ingredient.setName("apple");

        ingredient = ingredientRepository.save(ingredient);

        String body = objectMapper.writeValueAsString(ingredient);

        mockMvc.perform(post("/api/ingredient-items/").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertFalse(ingredientRepository.findAll().toString().contains("tea"));
    }

    @Test
    void getAllIngredientItems_validRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/ingredient-items/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains("tea"));

    }


    @Test
    void updateIngredientItem_validBody() throws Exception {
        ingredient.setName("apple");

        ingredient = ingredientRepository.save(ingredient);

        String body = objectMapper.writeValueAsString(ingredient);

        mockMvc.perform(put("/api/ingredient-items/" + ingredient.getId()).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(ingredientRepository.findAll().toString().contains("1"));
    }


    @Test
    void deleteIngredientItem_validRequest() throws Exception {
        ingredient = ingredientRepository.save(ingredient);

        mockMvc.perform(delete("/api/ingredient-items/" + ingredient.getId()))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(ingredientRepository.findAll().toString().contains("1"));
    }
}