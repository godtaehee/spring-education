package com.example.springeducation.lecture.repository;

import com.example.springeducation.lecture.dto.Category;
import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.UserDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LectureRepository {
    void createLecture(LectureDTO lectureDTO);
    List<UserDTO> findByStudents(Long id);
    List<LectureDTO> findByLecture(String teacherName,String lectureName,Long id,Category category);
    LectureDTO findByDetailLecture(Long id);
    void modifyLecture(Long id,String lectureName,String explain,Long price);
    void openLecture(Long id);
    boolean deleteLecture(Long id);
}
