package com.example.springeducation.user.service;

import com.example.springeducation.user.dto.RegisterUserDTO;

public interface UserService {
    void registerUser(RegisterUserDTO registerUserDTO);
    String findByPassword(Long id);
}
