package com.example.springeducation.lecture.dto;

import com.example.springeducation.user.dto.Grade;
import com.example.springeducation.user.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class LectureDTO {

    private Long id;

    private String lectureName;

    private String teacherName;

    private Long price;

    private List<UserDTO> studentList;

    private Category category;

    private Grade grade;

    private Date date;

    private Boolean open = false;

    private String explain;

    public LectureDTO(Long id,String lectureName,String teacherName,Long price,List<UserDTO> studentList,
                      Category category,Grade grade,Date date,String explain){
        this.id = id;
        this.lectureName = lectureName;
        this.teacherName = teacherName;
        this.price = price;
        this.studentList = studentList;
        this.category = category;
        this.grade = grade;
        this.date = date;
        this.explain = explain;
    }
}
