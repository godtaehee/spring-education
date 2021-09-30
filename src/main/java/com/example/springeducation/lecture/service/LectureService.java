package com.example.springeducation.lecture.service;

import com.example.springeducation.lecture.dto.Category;
import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.UserDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LectureService {
    void create(LectureDTO lectureDTO);
    List<UserDTO> findByStudents(Long id);
    List<LectureDTO> findByLecture(String teacherName, String lectureName, Long id, Category category);
}
