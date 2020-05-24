package com.fastcampus.admin.model.http.applycourse;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class ApplyCourseRegisterRequest {

    private Long studentId;     // 학생 id

    private Long courseId;      // 강좌 id

}
