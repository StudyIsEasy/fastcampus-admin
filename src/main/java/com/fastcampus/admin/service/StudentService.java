package com.fastcampus.admin.service;

import com.fastcampus.admin.entity.Student;
import com.fastcampus.admin.model.enumclass.StudentStatus;
import com.fastcampus.admin.model.http.StudentRequest;
import com.fastcampus.admin.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // TODO Create 로직을 생성해주세요.
    public Student create(StudentRequest studentRequest){

        return null;
    }

    // TODO 학생 read 로직을 생성해주세요
    public Optional<Student> read(Long id){
        return Optional.empty();
    }

    // TODO 학생 업데이트 로직을 생성해 주세요
    public Student update(StudentRequest studentRequest) {
        return null;
    }

    // TODO 학생 삭제 로직을 생성해주세요
    public void delete(Long id){
    }
}
