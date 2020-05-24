package com.fastcampus.admin.service;

import com.fastcampus.admin.entity.Student;
import com.fastcampus.admin.model.enumclass.StudentStatus;
import com.fastcampus.admin.model.http.Header;
import com.fastcampus.admin.model.http.Pagination;
import com.fastcampus.admin.model.http.student.StudentDetail;
import com.fastcampus.admin.model.http.student.StudentDetailResponse;
import com.fastcampus.admin.model.http.student.StudentRequest;
import com.fastcampus.admin.model.http.student.StudentResponse;
import com.fastcampus.admin.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Header<List<StudentResponse>> search(Pageable pageable) {
        Page<Student> students = studentRepository.findAll(pageable);
        List<StudentResponse> studentResponseList = students.stream()
                .map(student -> response(student))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(students.getTotalPages())
                .totalElements(students.getTotalElements())
                .currentPage(students.getNumber())
                .currentElements(students.getNumberOfElements())
                .build();

        return Header.OK(studentResponseList,pagination);
    }


    private StudentResponse response(Student student){
        return StudentResponse.builder()
                .id(student.getId())
                .account(student.getAccount())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .status(student.getStatus())
                .registeredAt(student.getRegisteredAt())
                .unregisteredAt(student.getUnregisteredAt())
                .build();
    }

    public StudentDetailResponse detail(Long id) {
        return studentRepository.findById(id)
                .map(student -> student.getApplyCourseList().stream()
                        .map(applyCourse -> StudentDetail.builder()
                                .courseTitle(applyCourse.getCourse().getTitle())
                                .progress(applyCourse.getProgressRate())
                                .build())
                        .collect(Collectors.toList()))
                .map(studentDetails -> StudentDetailResponse.builder()
                        .studentDetailList(studentDetails)
                        .build())
                .orElseGet(()->null);
    }
}
