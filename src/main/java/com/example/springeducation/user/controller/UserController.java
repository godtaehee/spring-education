package com.example.springeducation.user.controller;

import com.example.springeducation.user.dto.Grade;
import com.example.springeducation.user.dto.UserDTO;
import com.example.springeducation.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody   //return 시켜주고 싶은 데이터를 json 데이터로 변환시켜준다.
    @PostMapping("/registerUser")
    public UserDTO registerUser(){
        UserDTO userDTO = new UserDTO(123L,"Rabbit", Grade.TEACHER,"teacher123@naver.com",new Date());

        userService.save(userDTO);
        UserDTO teacher = userService.findByUser(123L);
        return teacher;
    }
}
