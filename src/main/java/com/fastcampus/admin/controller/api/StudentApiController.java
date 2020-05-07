package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.entity.Student;
import com.fastcampus.admin.model.http.StudentRequest;
import com.fastcampus.admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/student")
public class StudentApiController {

    private final StudentService studentService;

    @Autowired
    public StudentApiController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("")
    public Student create(@RequestBody StudentRequest studentRequest){
        return studentService.create(studentRequest);
    }

}
