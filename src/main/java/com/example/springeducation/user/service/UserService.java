package com.example.springeducation.user.service;

import com.example.springeducation.user.dto.RegisterUserDTO;
import com.example.springeducation.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public Long registerUser(RegisterUserDTO registerUserDTO) {
        return userRepository.registerUser(registerUserDTO);
    }

}
