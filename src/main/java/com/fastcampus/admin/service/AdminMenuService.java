package com.fastcampus.admin.service;

import com.fastcampus.admin.model.front.AdminMenu;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminMenuService {
    public List<AdminMenu> getAdminMenu(){

        return Arrays.asList(
                AdminMenu.builder()
                        .title("수강생 관리")
                        .url("/pages/student")
                        .code("student")
                        .build()
        );

    }
}
