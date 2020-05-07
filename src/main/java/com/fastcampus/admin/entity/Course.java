package com.fastcampus.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class Course extends BaseEntity{

    private String title;                           // 강좌 타이틀

    private String status;                          // 강좌 상태

    private String teacherName;                     // 강사 이름

    private String teacherPhoneNumber;              // 강사 전화번호

    private String teacherEmail;                    // 강사 이메일

    private BigDecimal amount;                      // 강좌 금액

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<CourseDetail> courseDetailList;    // 강좌 상세 리스트

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<ApplyCourse> applyCourseList;      // 수강신청 강좌 리스트

}
