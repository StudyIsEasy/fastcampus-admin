package com.fastcampus.admin.controller.api;

import com.fastcampus.admin.entity.Student;
import com.fastcampus.admin.model.http.StudentRequest;
import com.fastcampus.admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Student> read(@PathVariable Long id){
        return studentService.read(id);
    }

    @PutMapping("")
    public Student update(@RequestBody StudentRequest studentRequest){
        return studentService.update(studentRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
