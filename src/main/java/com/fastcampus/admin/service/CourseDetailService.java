package com.fastcampus.admin.service;

import com.fastcampus.admin.entity.CourseDetail;
import com.fastcampus.admin.model.http.CourseDetailRequest;
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

    // TODO 강좌 상세 Create 로직을 작성해주세요.
    public CourseDetail create(CourseDetailRequest courseDetailRequest) {
        return null;
    }

    // TODO 강좌 상세 read 로직을 작성해주세요.
    public Optional<CourseDetail> read(Long id) {
        return Optional.empty();
    }

    // TODO 강좌 상세 update 로직을 작성해주세요
    public CourseDetail update(CourseDetailRequest courseDetailRequest) {
        return null;
    }

    // todo 강좌 상세 delete 로직을 작성해주세요
    public void delete(Long id) {
    }
}
