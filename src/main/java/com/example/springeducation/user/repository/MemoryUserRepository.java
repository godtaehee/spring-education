package com.example.springeducation.user.repository;

import com.example.springeducation.user.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository{

    private static Map<Long,UserDTO> user = new HashMap<>();

    /**
     * 회원가입 등록
     */
    @Override
    public void save(UserDTO userDTO){
        user.put(userDTO.getId(), userDTO);
    }

    /**
     * 유저 정보 return
     */
    @Override
    public UserDTO findByUser(Long id){
        return user.get(id);
    }
}
