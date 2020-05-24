package com.fastcampus.admin.model.http.student;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class StudentDetail{
    private String courseTitle;
    private Integer progress;
}