package com.example.springeducation.lecture.service;

import com.example.springeducation.AutoAppConfig;
import com.example.springeducation.lecture.dto.Category;
import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.Grade;
import com.example.springeducation.user.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LectureServiceTest {
    LectureService lectureService;

    @BeforeEach
    void beforeEach(){
        /*AppConfig appConfig = new AppConfig();
        * lectureService = appConfig.lectureService();*/
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        lectureService = ac.getBean("lectureService",LectureService.class);
    }
    @Test
    void start(){
        List<UserDTO> studentList = new ArrayList<>();
        List<UserDTO> studentList2 = new ArrayList<>();
        List<UserDTO> studentList3 = new ArrayList<>();

        List<LectureDTO> lectureList = new ArrayList<>();

        studentList.add(new UserDTO(1L,"123",Grade.STUDENT,"Tony123@naver.com",new Date()));
        studentList.add(new UserDTO(2L,"231",Grade.STUDENT,"Huge123@naver.com",new Date()));
        studentList.add(new UserDTO(3L,"321",Grade.STUDENT,"Pok123@naver.com",new Date()));

        studentList2.add(new UserDTO(2L,"231",Grade.STUDENT,"Piter123@kakao.com",new Date()));
        studentList2.add(new UserDTO(4L,"222",Grade.STUDENT,"Nick123@kakao.com",new Date()));
        studentList2.add(new UserDTO(5L,"333",Grade.STUDENT,"Quick123@kakao.com",new Date()));

        studentList3.add(new UserDTO(1L,"123",Grade.STUDENT,"Moo123@google.com",new Date()));
        studentList3.add(new UserDTO(2L,"231",Grade.STUDENT,"Bob123@google.com",new Date()));
        studentList3.add(new UserDTO(5L,"333",Grade.STUDENT,"keria123@google.com",new Date()));

        lectureList.add(new LectureDTO(123L,"WEB-James","James",12000L,studentList,
                Category.WEB,Grade.TEACHER,new Date(),"James's lecture, price : 12000"));
        lectureList.add(new LectureDTO(124L,"WEB-Lee","Lee",13000L,studentList2,
                Category.WEB,Grade.TEACHER,new Date(),"Lee's lecture,price : 13000"));
        lectureList.add(new LectureDTO(125L,"WEB-Kim","Kim",14000L,studentList3,
                Category.WEB,Grade.TEACHER,new Date(),"Kim's lecture, price : 14000"));

        createLecture(lectureList);
        findByStudents(studentList);
        findByLectures(lectureList);
    }
    void createLecture(List<LectureDTO> lectureList){
        for(LectureDTO lectureDTO : lectureList){
            lectureService.createLecture(lectureDTO);
        }
    }
    void findByStudents(List<UserDTO> studentList){
        assertThat(lectureService.findByStudents(123L)).isEqualTo(studentList);
    }

    void findByLectures(List<LectureDTO> lectureList){
        String teacherName = "";
        String lectureName = "";
        Long id = 1L;
        Category category = Category.WEB;

        assertThat(lectureService.findByLecture(teacherName,lectureName,id,category)).size().isEqualTo(2);
    }
}