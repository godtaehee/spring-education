package com.example.springeducation.lecture.service;

import com.example.springeducation.AppConfig;
import com.example.springeducation.lecture.dto.Category;
import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.Grade;
import com.example.springeducation.user.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LectureServiceTest {
    LectureService lectureService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        lectureService = appConfig.lectureService();
    }
    @Test
    void create(){
        List<UserDTO> studentList = new ArrayList<>();

        studentList.add(new UserDTO(1L,"123",Grade.STUDENT));
        studentList.add(new UserDTO(2L,"231",Grade.STUDENT));
        studentList.add(new UserDTO(3L,"321",Grade.STUDENT));

        LectureDTO lectureDTO = new LectureDTO(123L,"WEB","James",studentList, Category.WEB,Grade.TEACHER);

        lectureService.create(lectureDTO);
        findByStudents(studentList);
    }
    void findByStudents(List<UserDTO> studentList){
        assertThat(lectureService.findByStudents(123L)).isEqualTo(studentList);
    }
}