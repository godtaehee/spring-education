package com.example.springeducation.user.controller;

import com.example.springeducation.user.dto.RegisterUserDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void checkUserController(){
        UserController userController = new UserController();
        assertNotNull(userController);
    }
    /**
     * 1. 유저정보를 받고
     * 2. service의 register함수를 호출
     */
    @Test
    @DisplayName("유저 회원가입에서 유저정보를 받는다")
    void registerUser(){

        RegisterUserDTO registerUserDto = new RegisterUserDTO();

        registerUserDto.setId(123L);
        registerUserDto.setPassword("1234");

        Assertions.assertThat(registerUserDto);
    }
}