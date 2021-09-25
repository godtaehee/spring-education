package com.example.springeducation.user.service;

import com.example.springeducation.user.dto.UserDTO;

public interface UserService {
    void save(UserDTO userDTO);
    UserDTO findByUser(Long id);
}
