package com.example.springeducation.user.controller;

import com.example.springeducation.user.dto.RegisterUserDTO;
import com.example.springeducation.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class UserControllerTest {
    @Test
    @DisplayName("registerUser 함수가 있어야한다.")
    void registerUserExist() {
        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        UserController userController = mock(UserController.class);
        assertNotNull(userController.registerUser(registerUserDTO));
    }

    // 1. 유저정보를 받는다.
    // 2. service의 registerUser함수를 호출하는것
    @Test
    @DisplayName("유저 회원가입에서 유저정보를 받는다.")
    void registerUser() {
        RegisterUserDTO registerUserDTO = new RegisterUserDTO(1L, "1234");
        assertEquals(registerUserDTO.getId(), 1L);
        assertEquals(registerUserDTO.getPassword(), "1234");
    }

    @Test
    @DisplayName("UserService registerUser method should be called with RegisterUserDTO")
    void checkRegisterUserParameter() {

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        RegisterUserDTO registerUserDTO = mock(RegisterUserDTO.class);
        when(userService.registerUser(registerUserDTO)).thenReturn(1L);
        given(userService.registerUser(registerUserDTO)).willReturn(1L);

        userController.registerUser(registerUserDTO);

        verify(userService, times(1)).registerUser(registerUserDTO);

    }
}