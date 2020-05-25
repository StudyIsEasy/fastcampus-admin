package com.fastcampus.admin.service;

import com.fastcampus.admin.entity.ApplyCourse;
import com.fastcampus.admin.model.http.ApplyCourseRequest;
import com.fastcampus.admin.respository.ApplyCourseRepository;
import com.fastcampus.admin.respository.CourseRepository;
import com.fastcampus.admin.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

// TODO Apply Course 서비스에 대해서 작성해 주세요 ( 수강강좌)
@Service
public class ApplyCourseService {

    private final ApplyCourseRepository applyCourseRepository;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public ApplyCourseService(ApplyCourseRepository applyCourseRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.applyCourseRepository = applyCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // TODO Apply Course 수강강좌 Create 서비스 로직을 작성해주세요
    public ApplyCourse create(ApplyCourseRequest applyCourseRequest) {

        return null;
    }

    // TODO 수강강좌 Read 로직을 작성해주세요
    public Optional<ApplyCourse> read(Long id) {
        // NotImp
        return null;
    }

    // TODO 수강생 강좌의 Update 로직을 작성해 주세요
    public ApplyCourse update(ApplyCourseRequest applyCourseRequest) {

        return null;
    }

    // TODO 수강생 강좌의 Delete 로직을 작성해주세요
    public void delete(Long id) {

    }
}
