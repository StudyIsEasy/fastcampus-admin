package com.fastcampus.admin.model.front;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class AdminMenu {
    private String title;
    private String url;
    private String code;
}
