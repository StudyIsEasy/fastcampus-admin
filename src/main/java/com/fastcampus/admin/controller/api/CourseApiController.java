package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.entity.Course;
import com.fastcampus.admin.model.http.CourseRequest;
import com.fastcampus.admin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/course")
public class CourseApiController {

    private final CourseService courseService;

    @Autowired
    public CourseApiController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("")
    public Course create(@RequestBody CourseRequest courseRequest){
        return courseService.create(courseRequest);
    }

    @GetMapping("/{id}")
    public Optional<Course> read(@PathVariable Long id){
        return courseService.read(id);
    }

    @PutMapping("")
    public Course update(@RequestBody CourseRequest courseRequest){
        return courseService.update(courseRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.ok().build();
    }

}
