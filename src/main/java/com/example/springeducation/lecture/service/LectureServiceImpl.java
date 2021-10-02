package com.example.springeducation.lecture.service;

import com.example.springeducation.lecture.dto.Category;
import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.lecture.repository.LectureRepository;
import com.example.springeducation.user.dto.Grade;
import com.example.springeducation.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    public LectureServiceImpl(LectureRepository lectureRepository){
        this.lectureRepository=lectureRepository;
    }

    @Override
    public void createLecture(LectureDTO lectureDTO) {
        if(lectureDTO.getGrade()== Grade.TEACHER) {
            lectureRepository.createLecture(lectureDTO);
        }
    }

    @Override
    public List<UserDTO> findByStudents(Long id) {
        return lectureRepository.findByStudents(id);
    }

    @Override
    public List<LectureDTO> findByLecture(String teacherName, String lectureName, Long id, Category category) {
        return lectureRepository.findByLecture(teacherName,lectureName,id,category);
    }

    @Override
    public LectureDTO findByDetailLecture(Long id) {
        return lectureRepository.findByDetailLecture(id);
    }

    @Override
    public void openLecture(Long id) {
        lectureRepository.openLecture(id);
    }

    @Override
    public void modifyLecture(Long id, String lectureName, String explain, Long price) {
        lectureRepository.modifyLecture(id,lectureName,explain,price);
    }

    @Override
    public boolean deleteLecture(Long id) {
        return lectureRepository.deleteLecture(id);
    }
}
