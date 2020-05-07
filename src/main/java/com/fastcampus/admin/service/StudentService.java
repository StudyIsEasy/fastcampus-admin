package com.fastcampus.admin.service;

import com.fastcampus.admin.entity.Student;
import com.fastcampus.admin.model.enumclass.StudentStatus;
import com.fastcampus.admin.model.http.StudentRequest;
import com.fastcampus.admin.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(StudentRequest studentRequest){
        Student student = Student.builder()
                .account(studentRequest.getAccount())
                .password(studentRequest.getPassword())
                .status(StudentStatus.REGISTERED)
                .email(studentRequest.getEmail())
                .phoneNumber(studentRequest.getPhoneNumber())
                .registeredAt(LocalDateTime.now())
                .build();
        return studentRepository.save(student);
    }
}
