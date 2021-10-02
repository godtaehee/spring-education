package com.example.springeducation.user.repository;

import com.example.springeducation.user.dto.UserDTO;

public interface UserRepository {
    void save(UserDTO UserDTO);
    UserDTO findByUser(Long userid);
    boolean addLecture(Long id,Long lectureId);
}
