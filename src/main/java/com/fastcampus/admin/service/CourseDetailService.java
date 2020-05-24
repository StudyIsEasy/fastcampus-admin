package com.fastcampus.admin.service;

import com.fastcampus.admin.entity.CourseDetail;
import com.fastcampus.admin.model.http.coursedetail.CourseDetailRequest;
import com.fastcampus.admin.respository.CourseDetailRepository;
import com.fastcampus.admin.respository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseDetailService {

    private final CourseDetailRepository courseDetailRepository;

    private final CourseRepository courseRepository;

    @Autowired
    public CourseDetailService(CourseDetailRepository courseDetailRepository, CourseRepository courseRepository) {
        this.courseDetailRepository = courseDetailRepository;
        this.courseRepository = courseRepository;
    }

    public CourseDetail create(CourseDetailRequest courseDetailRequest) {
        return Optional.of(courseDetailRequest.getCourseId())
                .map(courseRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(course -> CourseDetail.builder()
                        .title(courseDetailRequest.getTitle())
                        .content(courseDetailRequest.getContent())
                        .course(course)
                        .build())
                .map(courseDetailRepository::save)
                .orElseGet(()->null);
    }

    public Optional<CourseDetail> read(Long id) {
        return courseDetailRepository.findById(id);

    }

    public CourseDetail update(CourseDetailRequest courseDetailRequest) {
        return Optional.of(courseDetailRequest.getId())
                .map(courseDetailRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(courseDetail -> courseDetail.setTitle(courseDetailRequest.getTitle())
                        .setContent(courseDetailRequest.getContent()))
                .map(courseDetailRepository::save)
                .orElseGet(()->null);
    }

    public void delete(Long id) {
        courseDetailRepository.findById(id).ifPresent(courseDetailRepository::delete);
    }
}
