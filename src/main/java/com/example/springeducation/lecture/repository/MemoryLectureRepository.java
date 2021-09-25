package com.example.springeducation.lecture.repository;

import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.UserDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryLectureRepository implements LectureRepository{

    Map<Long,LectureDTO> lecture = new HashMap<>();

    /**
     * 강의를 생성(강사일때만 가능)
     */
    public void create(LectureDTO lectureDTO){
        lecture.put(lectureDTO.getId(),lectureDTO);
    }

    /**
     * 강의를 수강하는 학생들 정보를 return
     */
    @Override
    public List<UserDTO> findByStudents(Long id) {
        return lecture.get(id).getStudentList();
    }
}
