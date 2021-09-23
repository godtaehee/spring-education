package com.example.user.controller;

import com.example.user.dto.RegisterUserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Test
    @DisplayName("registerUser 함수가 있어야한다.")
    void registerUserExist() {
        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        UserController userController = new UserController();
        Assertions.assertNotNull(userController.registerUser(registerUserDTO));
    }

    // 1. 유저정보를 받는다.
    // 2. service의 registerUser함수를 호출하는것
    @Test
    @DisplayName("유저 회원가입에서 유저정보를 받는다.")
    void registerUser() {
        RegisterUserDTO registerUserDTO = new RegisterUserDTO(1L, "1234");

        Assertions.assertEquals(registerUserDTO.getId(), 1L);
        Assertions.assertEquals(registerUserDTO.getPassword(), "1234");
    }

}