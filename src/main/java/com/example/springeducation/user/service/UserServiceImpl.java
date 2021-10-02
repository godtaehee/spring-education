package com.example.springeducation.user.service;

import com.example.springeducation.user.dto.UserDTO;
import com.example.springeducation.user.repository.MemoryUserRepository;
import com.example.springeducation.user.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void save(UserDTO userDTO) {
        userRepository.save(userDTO);
    }

    @Override
    public UserDTO findByUser(Long id) {
        return userRepository.findByUser(id);
    }

    @Override
    public boolean addLecture(Long id, Long lectureId) {
        if(id==null){
            return false;
        }else {
            return userRepository.addLecture(id, lectureId);
        }
    }
}
