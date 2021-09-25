package com.example.springeducation.user.service;


import com.example.springeducation.user.dto.RegisterUserDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    void registerUser(){
        RegisterUserDTO registerUserDTO = new RegisterUserDTO(123L ,"Rabbit");
        userService.registerUser(registerUserDTO);

        String password = userService.findByPassword(123L);

        assertThat(password).isEqualTo(registerUserDTO.getPassword());
    }
}
