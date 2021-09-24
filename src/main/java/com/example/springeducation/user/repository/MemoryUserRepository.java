package com.example.springeducation.user.repository;

import com.example.springeducation.user.dto.RegisterUserDTO;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository{

    private static Map<Long,String> user = new HashMap<>();

    @Override
    public void registerUser(RegisterUserDTO registerUserDTO){
        user.put(registerUserDTO.getId(),registerUserDTO.getPassword());
    }
    @Override
    public String findByPassword(Long id){
        return user.get(id);
    }
}
