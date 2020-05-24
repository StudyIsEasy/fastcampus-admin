package com.fastcampus.admin.service;

import com.fastcampus.admin.entity.*;
import com.fastcampus.admin.model.http.applycourse.ApplyCourseRegisterRequest;
import com.fastcampus.admin.model.http.applycourse.ApplyCourseRequest;
import com.fastcampus.admin.model.http.applycourse.ApplyCourseStatusResponse;
import com.fastcampus.admin.respository.ApplyCourseDetailRepository;
import com.fastcampus.admin.respository.ApplyCourseRepository;
import com.fastcampus.admin.respository.CourseRepository;
import com.fastcampus.admin.respository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplyCourseService {

    private final ApplyCourseRepository applyCourseRepository;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final ApplyCourseDetailRepository applyCourseDetailRepository;

    public ApplyCourseService(ApplyCourseRepository applyCourseRepository, StudentRepository studentRepository, CourseRepository courseRepository, ApplyCourseDetailRepository applyCourseDetailRepository) {
        this.applyCourseRepository = applyCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.applyCourseDetailRepository = applyCourseDetailRepository;
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
                                .progressRate(0)
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

    @Transactional
    public ResponseEntity<Object> register(ApplyCourseRegisterRequest applyCourseRegisterRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(applyCourseRegisterRequest.getStudentId());
        Optional<Course> optionalCourse = courseRepository.findById(applyCourseRegisterRequest.getCourseId());

        if(optionalStudent.isPresent() && optionalCourse.isPresent()){
            Student student = optionalStudent.get();
            Course course = optionalCourse.get();

            ApplyCourse applyCourse = ApplyCourse.builder()
                    .course(course)
                    .student(student)
                    .status("REGISTERED")
                    .expireAt(LocalDateTime.now().plusMonths(3))
                    .isComplete(false)
                    .progressRate(0)
                    .build();
            applyCourseRepository.save(applyCourse);

            List<ApplyCourseDetail> applyCourseDetailList = course.getCourseDetailList()
                    .stream()
                    .map(detail -> ApplyCourseDetail.builder()
                            .courseDetailId(detail.getId())
                            .applyCourse(applyCourse)
                            .build())
                    .map(applyCourseDetailRepository::save)
                    .collect(Collectors.toList());


            applyCourse.setApplyCourseDetailList(applyCourseDetailList);
            applyCourseRepository.save(applyCourse);

            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    public ApplyCourseStatusResponse status(Long applyCourseId, Long studentId) {
        return applyCourseRepository.findById(applyCourseId)
                .filter(applyCourse -> applyCourse.getStudent().getId().equals(studentId))
                .map(applyCourse -> {

                    applyCourse.setProgress();

                    return ApplyCourseStatusResponse.builder()
                            .applyCourseId(applyCourse.getId())
                            .isComplete(applyCourse.getIsComplete())
                            .progress(applyCourse.getProgressRate())
                            .title(applyCourse.getCourse().getTitle())
                            .studentId(applyCourse.getStudent().getId())
                            .build();
                })
                .orElseGet(()->null);
    }
}
