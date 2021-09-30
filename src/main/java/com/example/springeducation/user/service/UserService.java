package com.example.springeducation.user.service;


import com.example.springeducation.user.dto.UserDTO;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    void save(UserDTO userDTO);
    UserDTO findByUser(Long id);
}
