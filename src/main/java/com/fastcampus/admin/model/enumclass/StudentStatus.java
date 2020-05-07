package com.fastcampus.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudentStatus {

    REGISTERED(1,"등록상태"),
    UNREGISTERED(2,"해지상태")
    ;

    private Integer id;
    private String title;

}
