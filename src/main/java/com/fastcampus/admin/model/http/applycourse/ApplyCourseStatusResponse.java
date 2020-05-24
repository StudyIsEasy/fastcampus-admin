package com.fastcampus.admin.model.http.applycourse;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class ApplyCourseStatusResponse {


    private Long studentId;

    private Long applyCourseId;

    private String title;

    private Integer progress;

    private boolean isComplete;
}
