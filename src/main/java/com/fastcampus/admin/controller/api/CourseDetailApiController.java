package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.entity.CourseDetail;
import com.fastcampus.admin.model.http.coursedetail.CourseDetailRequest;
import com.fastcampus.admin.service.CourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/course-detail")
public class CourseDetailApiController {

    private final CourseDetailService courseDetailService;

    @Autowired
    public CourseDetailApiController(CourseDetailService courseDetailService) {
        this.courseDetailService = courseDetailService;
    }

    @PostMapping("")
    public CourseDetail create(@RequestBody CourseDetailRequest courseDetailRequest){
        return courseDetailService.create(courseDetailRequest);
    }

    @GetMapping("/{id}")
    public Optional<CourseDetail> read(@PathVariable Long id){
        return courseDetailService.read(id);
    }

    @PutMapping("")
    public CourseDetail update(@RequestBody CourseDetailRequest courseDetailRequest){
        return courseDetailService.update(courseDetailRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        courseDetailService.delete(id);
        return ResponseEntity.ok().build();
    }
}
