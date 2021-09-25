package com.example.springeducation.lecture.service;

import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.UserDTO;

import java.util.List;

public interface LectureService {
    void create(LectureDTO lectureDTO);
    List<UserDTO> findByStudents(Long id);
}
