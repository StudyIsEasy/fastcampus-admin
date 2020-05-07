package com.fastcampus.admin.repository;

import com.fastcampus.admin.entity.Student;
import com.fastcampus.admin.model.enumclass.StudentStatus;
import com.fastcampus.admin.respository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("학생 repository 테스트")
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    public void create(){

        Student student = Student.builder()
                .account("student01")
                .password("student01")
                .status(StudentStatus.REGISTERED)
                .email("student01@gmail.com")
                .phoneNumber("010-1111-1111")
                .registeredAt(LocalDateTime.now())
                .build();

        Student newStudent = studentRepository.save(student);
        Assert.notNull(newStudent,"");
    }

    @Test
    @Transactional
    public void read(){
        Student student = Student.builder()
                .account("student01")
                .password("student01")
                .status(StudentStatus.REGISTERED)
                .email("student01@gmail.com")
                .phoneNumber("010-1111-1111")
                .registeredAt(LocalDateTime.now())
                .build();
        Student temp = studentRepository.save(student);

        Optional<Student> newStudent = studentRepository.findById(temp.getId());
        Assert.isTrue(newStudent.isPresent(),"");
    }

    @Test
    @Transactional
    public void update(){
        Student temp = studentRepository.save(createStudent());

        Student student = studentRepository.getOne(temp.getId());
        student.setStatus(StudentStatus.UNREGISTERED);
        studentRepository.save(student);

        Optional<Student> newStudent = studentRepository.findById(student.getId());
        Assert.isTrue(newStudent.isPresent(),"");
        Assert.isTrue(newStudent.get().getStatus().equals(StudentStatus.UNREGISTERED),"");
    }

    @Test
    @Transactional
    public void delete(){
        Student student = Student.builder()
                .account("student01")
                .password("student01")
                .status(StudentStatus.REGISTERED)
                .email("student01@gmail.com")
                .phoneNumber("010-1111-1111")
                .registeredAt(LocalDateTime.now())
                .build();
        Student temp = studentRepository.save(student);
        studentRepository.delete(temp);

        Optional<Student> delete = studentRepository.findById(temp.getId());
        Assert.isTrue(!delete.isPresent(),"");
    }


    public Student createStudent(){
        return Student.builder()
                .account("student01")
                .password("student01")
                .status(StudentStatus.REGISTERED)
                .email("student01@gmail.com")
                .phoneNumber("010-1111-1111")
                .registeredAt(LocalDateTime.now())
                .build();
    }
}
