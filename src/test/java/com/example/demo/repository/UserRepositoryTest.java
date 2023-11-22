package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;


import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUser_whenSave_thenReturnSavedUser() {

        User user = new User("AAAAAll", "AAAAAAAllA", "AAAlam@gmail.com", "010110234");

        User savedUser = userRepository.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("AAAAAll");
    }

    @Test
    public void givenUser_whenFindById_thenReturnUser() {

        userRepository.save(new User("Joollkkkoo", "llloh00", "johhloo@gmail.com", "12h0l034"));

        User user = userRepository.findById(1L).get();

        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo("Amal");
    }

    @Test
    public void givenSavedUser_whenFindAll_thenReturnUserList() {

        userRepository.save(new User("Aaagaha", "lla0aag0o", "aaagaagla@gmail.com", "Alaaa01255734"));
        userRepository.save(new User("Nhaagaaa", "sooaaagso", "nuggaaaaa@gmail.com", "Nhaa001552734"));

        List<User> userList = userRepository.findAll();

        assertThat(userList).hasSize(19);
    }
}