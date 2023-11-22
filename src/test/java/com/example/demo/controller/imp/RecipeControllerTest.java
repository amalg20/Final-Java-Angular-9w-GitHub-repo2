package com.example.demo.controller.imp;

import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    WebApplicationContext webApplicationContext;
    Recipe recipe;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        recipe = new Recipe("coffee", "single shot", "coffee.png", null);
    }

    @Test
    void getAllRecipes_validRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/recipes")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains("tea"));

    }


    @Test
    void createRecipe_validBody() throws Exception {
        recipe.setTitle("coffee");

        recipe = recipeRepository.save(recipe);

        String body = objectMapper.writeValueAsString(recipe);

        mockMvc.perform(post("/api/recipes").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
        assertFalse(recipeRepository.findAll().toString().contains("tea"));
    }

    @Test
    void updateRecipe_validBody() throws Exception {
        recipe.setTitle("coffee");

        recipe = recipeRepository.save(recipe);

        String body = objectMapper.writeValueAsString(recipe);

        mockMvc.perform(put("/api/recipes/" + recipe.getId()).content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        assertTrue(recipeRepository.findAll().toString().contains("1"));

    }


    @Test
    void deleteRecipe_validRequest() throws Exception {
        recipe = recipeRepository.save(recipe);

        mockMvc.perform(delete("/api/recipes/" + recipe.getId())).andExpect(status().isOk()).andReturn();

        assertTrue(userRepository.findAll().toString().contains("1"));
    }
}