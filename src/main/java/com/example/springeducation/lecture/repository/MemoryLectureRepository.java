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

        /**
         * 만약 파라미터가 null이거나 빈칸이면 조건을 주지 않은 것이니 전부 해당
         * 파라미터 값이 존재한다면 해당 값에 부여하는지 체크 후 list 추가
         */
        List<LectureDTO> list = new ArrayList<>();

        for(Map.Entry<Long,LectureDTO> map : lecture.entrySet()){
            Long key = map.getKey();
            LectureDTO value = map.getValue();

            if(teacherName!=null && teacherName!=""){
                if(value.getTeacherName()!=teacherName){
                    continue;
                }
            }
            if(lectureName!=null && lectureName!=""){
                if(value.getLectureName()!=lectureName){
                    continue;
                }
            }
            if(studentId!=null){
                int count=0;
                for(UserDTO userDTO : value.getStudentList()){
                    if(studentId==userDTO.getId()){
                        count++;
                    }
                }
                if(count<=0){
                    continue;
                }
            }
            if(category!=null){
                if(value.getCategory()!=category){
                    continue;
                }
            }
            list.add(value);
        }
        /**
         * 최신순/수강생수 로 정렬
         */
        list.sort((x,y)->{
            if(x.getDate()==y.getDate()){
                return x.getStudentList().size()-y.getStudentList().size();
            }
            return x.getDate().compareTo(y.getDate());
        });
        //list.forEach(x-> System.out.println(x.getPrice()));
        return list;
    }
}
