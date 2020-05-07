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

    public ApplyCourse create(ApplyCourseRequest applyCourseRequest) {
        return Optional.of(applyCourseRequest.getStudentId())
                .map(studentRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(student -> courseRepository.findById(applyCourseRequest.getCourseId())
                        .map( course -> ApplyCourse.builder()
                                .student(student)
                                .course(course)
                                .status("REGISTERED")
                                .progressRate(0f)
                                .isComplete(false)
                                .expireAt(LocalDateTime.now().plusYears(1L))
                                .build()
                        )
                        .orElseGet(()->null))
                .map(applyCourseRepository::save)
                .orElseGet(()->null);
    }

    public Optional<ApplyCourse> read(Long id) {
        return applyCourseRepository.findById(id);
    }

    public ApplyCourse update(ApplyCourseRequest applyCourseRequest) {
        return Optional.of(applyCourseRequest.getId())
                .map(applyCourseRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(applyCourse -> applyCourse
                        .setProgressRate(applyCourseRequest.getProgressRate())
                        .setIsComplete(applyCourseRequest.getIsComplete())
                        .setExpireAt(LocalDateTime.parse(applyCourseRequest.getExpireAt())))
                .map(applyCourseRepository::save)
                .orElseGet(()->null);
    }

    public void delete(Long id) {
        applyCourseRepository.findById(id).ifPresent(applyCourseRepository::delete);
    }
}
