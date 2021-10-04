package com.example.springeducation.user.service;


import com.example.springeducation.AppConfig;
import com.example.springeducation.user.dto.Grade;
import com.example.springeducation.user.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;

class UserServiceTest {

    UserService userService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        userService = appConfig.userService();

    }

    @Test
    void save(){
        UserDTO userDTO = new UserDTO(123L ,"Rabbit", Grade.STUDENT,"rabbit123@naver.com",new Date());
        userService.save(userDTO);

        UserDTO user = userService.findByUser(123L);

        assertThat(user.getGrade()).isEqualTo(userDTO.getGrade());
    }
}
