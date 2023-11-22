package com.example.demo.controller.imp;

import com.example.demo.model.Category;
import com.example.demo.model.Ingredient;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.IngredientRepository;
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
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    WebApplicationContext webApplicationContext;
    Category category;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        category = new Category("Sandwich", null);
    }

    @Test
    void saveCategoryItem_validBody() throws Exception {
        category.setName("apple");

        category = categoryRepository.save(category);

        String body = objectMapper.writeValueAsString(category);

        mockMvc.perform(post("/api/category-items/").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertFalse(categoryRepository.findAll().toString().contains("tea"));
    }

    @Test
    void getAllCategoryItems_validRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/category-items/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains("tea"));

    }


    @Test
    void updateCategoryItem_validBody() throws Exception {
        category.setName("apple");

        category = categoryRepository.save(category);

        String body = objectMapper.writeValueAsString(category);

        mockMvc.perform(put("/api/category-items/" + category.getId()).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(categoryRepository.findAll().toString().contains("1"));
    }

    @Test
    void deleteCategoryItem_validRequest() throws Exception {
        category = categoryRepository.save(category);

        mockMvc.perform(delete("/api/ingredient-items/" + category.getId()))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(categoryRepository.findAll().toString().contains("1"));
    }
}