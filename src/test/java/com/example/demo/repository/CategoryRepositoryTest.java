package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.model.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void givenCategory_whenSave_thenReturnSavedCategory() {

        Category category = new Category("Sandwich", null);
        categoryRepository.save(category);

        Category savedCategory = categoryRepository.save(category);

        assertThat(savedCategory.getName()).isEqualTo("Sandwich");
    }

    @Test
    public void givenCategory_whenFindById_thenReturnCategory() {

        Category category = new Category("Sandwich", null);
        categoryRepository.save(category);

        Category item = categoryRepository.findById(category.getId()).get();

        assertThat(item.getName()).isEqualTo("Sandwich");
    }

}
