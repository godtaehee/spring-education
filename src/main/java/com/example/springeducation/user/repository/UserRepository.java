package com.example.springeducation.user.repository;

import com.example.springeducation.user.dto.RegisterUserDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class UserRepository {

    private static Map<Long, String> database = new HashMap<>();

    public Long registerUser(RegisterUserDTO registerUserDTO) {
        database.put(registerUserDTO.getId(), registerUserDTO.getPassword());
        return registerUserDTO.getId();
    }

}
