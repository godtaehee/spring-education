package com.example.springeducation.user.controller;

import com.example.springeducation.user.dto.RegisterUserDTO;
import com.example.springeducation.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public Long registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
        return userService.registerUser(registerUserDTO);
    }

}
