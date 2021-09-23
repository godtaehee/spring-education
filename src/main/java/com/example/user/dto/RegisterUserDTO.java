package com.example.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class RegisterUserDTO {
    Long id;
    String password;

    public RegisterUserDTO() { }

    public RegisterUserDTO(Long id, String password) {
        this.id = id;
        this.password = password;
    }
}
