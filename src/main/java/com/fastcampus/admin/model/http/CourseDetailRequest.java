package com.fastcampus.admin.model.http;

import com.fastcampus.admin.entity.Course;
import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class CourseDetailRequest {
    private Long id;                // id
    private String title;           // 강좌 상세 타이틀
    private String content;         // 강좌 상세 컨텐츠
    private Long courseId;          // 강좌 id
}
