package com.fastcampus.admin.model.http.course;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class CourseRequest {
    private Long id;                                // id

    private String title;                           // 강좌 타이틀

    private String teacherName;                     // 강사 이름

    private String teacherPhoneNumber;              // 강사 전화번호

    private String teacherEmail;                    // 강사 이메일

    private BigDecimal amount;                      // 강좌 금액
}
