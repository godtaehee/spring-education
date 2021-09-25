package com.example.springeducation.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String password;
    private Grade grade;

    public UserDTO(Long id, String password,Grade grade){
        this.id = id;
        this.password = password;
        this.grade=grade;
    }
}
