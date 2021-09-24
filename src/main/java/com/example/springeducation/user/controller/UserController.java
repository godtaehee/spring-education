package com.example.springeducation.user.controller;

import com.example.springeducation.user.dto.RegisterUserDTO;
import com.example.springeducation.user.service.UserService;
import com.example.springeducation.user.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService = new UserServiceImpl();

    @ResponseBody   //return 시켜주고 싶은 데이터를 json 데이터로 변환시켜준다.
    @PostMapping("/registerUser")
    public String registerUser(){
        RegisterUserDTO registerUserDTO = new RegisterUserDTO(123L,"Rabbit");

        userService.registerUser(registerUserDTO);
        String password = userService.findByPassword(123L);
        return password;
    }
}