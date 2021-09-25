package com.example.springeducation.user.dto;

import lombok.Getter;

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
