package com.example.springeducation.user.repository;

import com.example.springeducation.user.dto.RegisterUserDTO;

public interface UserRepository {
    void registerUser(RegisterUserDTO RegisterUserDTO);
    String findByPassword(Long userid);
}
