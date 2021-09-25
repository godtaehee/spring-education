package com.example.springeducation.lecture.repository;

import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.UserDTO;

import java.util.List;

public interface LectureRepository {
    void create(LectureDTO lectureDTO);
    List<UserDTO> findByStudents(Long id);
}
