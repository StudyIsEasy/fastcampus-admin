package com.fastcampus.admin.model.http.student;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class StudentDetailResponse {
    private List<StudentDetail> studentDetailList;
}

