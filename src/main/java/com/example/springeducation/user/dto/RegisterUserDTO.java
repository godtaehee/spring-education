package com.example.springeducation.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserDTO {
    Long id;
    String password;

    public RegisterUserDTO(Long id,String password){
        this.id = id;
        this.password = password;
    }
}
