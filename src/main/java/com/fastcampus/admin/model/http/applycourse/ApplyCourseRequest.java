package com.fastcampus.admin.model.http.applycourse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class ApplyCourseRequest {
    private Long id;                    // id
    private Integer progressRate;         // 진행률
    private Boolean isComplete;         // 강의 완료 여부
    private String expireAt;            // 강의 만료 일
    private Long studentId;             // 학생 id
    private Long courseId;              // 강좌 id
}
