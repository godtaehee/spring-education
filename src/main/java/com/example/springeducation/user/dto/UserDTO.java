package com.example.springeducation.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String password;

    private Grade grade;

    private String email;

    private Date applyDate;

    private List<Long> lectureId;

    public UserDTO(Long id, String password,Grade grade,String email,Date applyDate){
        this.id = id;
        this.password = password;
        this.grade=grade;
        this.email=email;
        this.applyDate=applyDate;
    }
}
