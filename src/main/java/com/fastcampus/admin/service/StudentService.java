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

    public Optional<Student> read(Long id){
        return studentRepository.findById(id);
    }

    public Student update(StudentRequest studentRequest) {
        return Optional.of(studentRequest.getId())
                .map(studentRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(student ->{
                    student.setAccount(studentRequest.getAccount());
                    student.setPassword(studentRequest.getPassword());
                    student.setEmail(studentRequest.getEmail());
                    student.setPhoneNumber(studentRequest.getPhoneNumber());
                    return student;
                })
                .map(studentRepository::save)
                .orElseGet(()->null);
    }

    public void delete(Long id){
        studentRepository.findById(id).ifPresent(studentRepository::delete);
    }
}
