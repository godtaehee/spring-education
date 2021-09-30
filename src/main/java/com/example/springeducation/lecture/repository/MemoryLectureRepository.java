package com.example.springeducation.lecture.repository;

import com.example.springeducation.lecture.dto.Category;
import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.UserDTO;
import org.springframework.context.annotation.Bean;

import java.util.*;

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

    /**
     * 검색 조건에 맞는 강의를 return
     */
    @Override
    public List<LectureDTO> findByLecture(String teacherName, String lectureName, Long studentId, Category category) {

        List<LectureDTO> list = new ArrayList<>();

        for(Map.Entry<Long,LectureDTO> map : lecture.entrySet()){
            Long key = map.getKey();
            LectureDTO value = map.getValue();

            Category valueCategory = value.getCategory();
            String valueLectureName = value.getLectureName();
            String valueTeacherName = value.getTeacherName();

            for(UserDTO userDTO : value.getStudentList()) {
                if (valueTeacherName == teacherName && valueLectureName == lectureName && userDTO.getId() == studentId){
                    list.add(value);
                }
            }
        }
        /*list.sort((x,y)->{
            if(x.)
        })*/
        return list;
    }
}
