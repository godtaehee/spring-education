package com.example.springeducation.user.repository;

import com.example.springeducation.user.dto.UserDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryUserRepository implements UserRepository{

    private static Map<Long,UserDTO> user = new HashMap<>();

    /**
     * 회원가입 등록
     */
    @Override
    public void save(UserDTO userDTO){
        user.put(userDTO.getId(), userDTO);
    }

    /**
     * 유저 정보 return
     */
    @Override
    public UserDTO findByUser(Long id){
        return user.get(id);
    }

    /**
     * 수강생이 신청한 강의 추가(중복된 강의 수강 x,삭제된 강의 x,비공개된 강의 x)
     */
    @Override
    public boolean addLecture(Long id,Long lectureId) {
        //중복된 강의 체크
        List<Long> lectureId1 = user.get(id).getLectureId();
        for(Long lecture : lectureId1){
            if(lecture==lectureId){
                return false;
            }
        }
        //삭제된 강의 체크
        //비공개된 강의 체크

        //=> 이 모든걸 쿼리로 작성하면 해결됨
        lectureId1.add(lectureId);
        return true;
    }
}
