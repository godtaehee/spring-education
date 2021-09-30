package com.example.springeducation.user.service;

<<<<<<< Updated upstream
import com.example.springeducation.user.dto.UserDTO;
=======
import com.example.springeducation.user.dto.RegisterUserDTO;
import org.springframework.stereotype.Service;
>>>>>>> Stashed changes

@Service
public interface UserService {
    void save(UserDTO userDTO);
    UserDTO findByUser(Long id);
}
