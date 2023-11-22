package com.example.demo.repository;


import com.example.demo.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void givenRole_whenSave_thenReturnSavedRole() {

        Role role = new Role("extra sugar");
        roleRepository.save(role);

        Role savedRole = roleRepository.save(role);

        assertThat(savedRole.getName()).isEqualTo("extra sugar");
    }

    @Test
    public void givenRole_whenFindById_thenReturnRole() {

        Role role = new Role("vegan");
        roleRepository.save(role);

        Role item = roleRepository.findById(role.getId()).get();

        assertThat(item.getName()).isEqualTo("vegan");
    }

}