package com.example.springeducation.lecture.service;

import com.example.springeducation.lecture.dto.Category;
import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.UserDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface LectureService {
    void createLecture(LectureDTO lectureDTO);
    List<UserDTO> findByStudents(Long id);
    List<LectureDTO> findByLecture(String teacherName, String lectureName, Long id, Category category);
    LectureDTO findByDetailLecture(Long id);
    void openLecture(Long id);
    void modifyLecture(Long id,String lectureName,String explain,Long price);
    boolean deleteLecture(Long id);
}
