package com.example.springeducation;

import com.example.springeducation.lecture.repository.LectureRepository;
import com.example.springeducation.lecture.repository.MemoryLectureRepository;
import com.example.springeducation.lecture.service.LectureService;
import com.example.springeducation.lecture.service.LectureServiceImpl;
import com.example.springeducation.user.repository.MemoryUserRepository;
import com.example.springeducation.user.repository.UserRepository;
import com.example.springeducation.user.service.UserService;
import com.example.springeducation.user.service.UserServiceImpl;
import org.apache.catalina.User;

public class AppConfig {

    public UserRepository userRepository(){
        return new MemoryUserRepository();
    }
    public UserService userService(){
        return new UserServiceImpl(userRepository());
    }

    public LectureRepository lectureRepository(){
        return new MemoryLectureRepository();
    }

    public LectureService lectureService(){
        return new LectureServiceImpl(lectureRepository());
    }
}
