package com.example.user.controller;

import com.example.user.dto.RegisterUserDTO;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {
    @PostMapping("/register")
    public Long registerUser(RegisterUserDTO registerUserDTO) {
        return 1L;
    }
}
