package com.example.springeducation.user.service;

import com.example.springeducation.user.dto.RegisterUserDTO;
import com.example.springeducation.user.repository.MemoryUserRepository;
import com.example.springeducation.user.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = new MemoryUserRepository();

    @Override
    public void registerUser(RegisterUserDTO registerUserDTO) {
        userRepository.registerUser(registerUserDTO);
    }

    @Override
    public String findByPassword(Long id) {
        return userRepository.findByPassword(id);
    }
}
