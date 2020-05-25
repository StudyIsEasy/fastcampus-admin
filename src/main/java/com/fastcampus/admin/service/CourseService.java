package com.fastcampus.admin.service;

import com.fastcampus.admin.entity.Course;
import com.fastcampus.admin.model.http.CourseRequest;
import com.fastcampus.admin.respository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // TODO Create 로직을 생성해주세요.
    public Course create(CourseRequest courseRequest){

       return null;
    }

    public Optional<Course> read(Long id){
        return Optional.empty();
    }

    public Course update(CourseRequest courseRequest){
       return null;
    }

    public void delete(Long id){
    }
}
