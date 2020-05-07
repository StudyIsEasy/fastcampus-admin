package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.entity.ApplyCourse;
import com.fastcampus.admin.model.http.ApplyCourseRequest;
import com.fastcampus.admin.service.ApplyCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// TODO 해당 내용은 2차 최종과제의 1번 기능입니다.
@RestController
@RequestMapping("/v1/apply-course")
public class ApplyCourseApiController {

    private final ApplyCourseService applyCourseService;

    public ApplyCourseApiController(ApplyCourseService applyCourseService) {
        this.applyCourseService = applyCourseService;
    }

    @PostMapping("")
    public ApplyCourse create(@RequestBody ApplyCourseRequest applyCourseRequest){
        return applyCourseService.create(applyCourseRequest);
    }

    @GetMapping("/{id}")
    public Optional<ApplyCourse> read(@PathVariable Long id){
        return applyCourseService.read(id);
    }

    @PutMapping("")
    public ApplyCourse update(@RequestBody ApplyCourseRequest applyCourseRequest){
        return applyCourseService.update(applyCourseRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        applyCourseService.delete(id);
        return ResponseEntity.ok().build();
    }
}
