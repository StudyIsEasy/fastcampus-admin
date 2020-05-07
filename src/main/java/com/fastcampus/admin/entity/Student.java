package com.fastcampus.admin.entity;

import com.fastcampus.admin.model.enumclass.StudentStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class Student extends BaseEntity{

    private String account;                     // 수강생 계정

    private String password;                    // 수강생 계정 비밀번호

    @Enumerated(EnumType.STRING)
    private StudentStatus status;               // 수강생 상태

    private String email;                       // 수강생 이메일주소

    private String phoneNumber;                 // 수강생 전화번호

    private LocalDateTime registeredAt;         // 수강생 등록일자

    private LocalDateTime unregisteredAt;       // 수강생 해지일자

    @OneToMany(mappedBy = "student")
    private List<ApplyCourse> applyCourseList;  // 수강 강좌 목록

}
