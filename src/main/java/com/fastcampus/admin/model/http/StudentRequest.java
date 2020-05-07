package com.fastcampus.admin.model.http;

import com.fastcampus.admin.model.enumclass.StudentStatus;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class StudentRequest {
    private Long id;                            // id
    private String account;                     // 수강생 계정
    private String password;                    // 수강생 계정 비밀번호
    private String email;                       // 수강생 이메일주소
    private String phoneNumber;                 // 수강생 전화번호
}
