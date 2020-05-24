package com.fastcampus.admin.model.http.student;

import com.fastcampus.admin.model.enumclass.StudentStatus;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class StudentResponse {

    private Long id;

    private String account;                     // 수강생 계정

    private String password;                    // 수강생 계정 비밀번호

    @Enumerated(EnumType.STRING)
    private StudentStatus status;               // 수강생 상태

    private String email;                       // 수강생 이메일주소

    private String phoneNumber;                 // 수강생 전화번호

    private LocalDateTime registeredAt;         // 수강생 등록일자

    private LocalDateTime unregisteredAt;       // 수강생 해지일자
}
