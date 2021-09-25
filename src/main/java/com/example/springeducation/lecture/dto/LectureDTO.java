package com.example.springeducation.lecture.dto;

import com.example.springeducation.user.dto.Grade;
import com.example.springeducation.user.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LectureDTO {

    private Long id;

    private String lectureName;

    private String teacherName;

    private List<UserDTO> studentList;

    private Category category;

    private Grade grade;

    public LectureDTO(Long id,String lectureName,String teacherName,List<UserDTO> studentList, Category category,Grade grade){
        this.id=id;
        this.lectureName=lectureName;
        this.teacherName=teacherName;
        this.studentList=studentList;
        this.category=category;
        this.grade=grade;
    }
}
