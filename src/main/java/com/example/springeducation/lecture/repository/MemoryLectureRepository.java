package com.example.springeducation.lecture.repository;

import com.example.springeducation.lecture.dto.Category;
import com.example.springeducation.lecture.dto.LectureDTO;
import com.example.springeducation.user.dto.UserDTO;
import org.springframework.context.annotation.Bean;

import java.util.*;

public class MemoryLectureRepository implements LectureRepository{

    Map<Long,LectureDTO> lecture = new HashMap<>();

    /**
     * 강의를 생성(강사일때만 가능,처음 생성시 비공개)
     */
    public void createLecture(LectureDTO lectureDTO){
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


    /**
     * 강의 상세 조회(강의 id 값으로 조회)
     */
    @Override
    public LectureDTO findByDetailLecture(Long id) {
        for(Map.Entry<Long,LectureDTO> lectureDTO : lecture.entrySet()){
            Long lectureId = lectureDTO.getValue().getId();
            if(id==lectureId){
                return lectureDTO.getValue();
            }
        }
        return null;
    }

    /**
     * 강의 수정
     */
    @Override
    public void modifyLecture(Long id,String lectureName,String explain,Long price) {
        for(Map.Entry<Long,LectureDTO> lectureDto : lecture.entrySet()){
            if(id==lectureDto.getValue().getId()){
                if(lectureName!=null){
                    lectureDto.getValue().setLectureName(lectureName);
                }
                if(explain!=null){
                    lectureDto.getValue().setExplain(explain);
                }
                if(price!=null){
                    lectureDto.getValue().setPrice(price);
                }
            }
        }
    }

    /**
     * 강의 오픈
     */
    @Override
    public void openLecture(Long id) {
        for(Map.Entry<Long,LectureDTO> lectureDto : lecture.entrySet()){
            if(id==lectureDto.getValue().getId()){
                lectureDto.getValue().setOpen(true);
            }
        }
    }

    /**
     * 강의 삭제
     */
    @Override
    public boolean deleteLecture(Long id) {
        LectureDTO lectureDTO = lecture.remove(id);
        if(lectureDTO!=null){
            return true;
        }else{
            return false;
        }
    }
}
