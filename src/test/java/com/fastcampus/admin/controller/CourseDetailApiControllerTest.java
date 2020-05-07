package com.fastcampus.admin.controller;

import com.fastcampus.admin.entity.CourseDetail;
import com.fastcampus.admin.model.http.CourseDetailRequest;
import com.fastcampus.admin.model.http.CourseRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CourseDetailApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        CourseDetailRequest courseDetailRequest = CourseDetailRequest.builder()
                .title("2강")
                .content("JAVA 설치")
                .courseId(2L)
                .build();


        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/course-detail")
                .build()
                .toUri();

        mockMvc.perform(post(uri)
                .content(objectMapper.writeValueAsString(courseDetailRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("1강"))
                .andDo(print());
    }

    @Test
    public void readTest() throws Exception {
        Long id = 3L;

        Map<String, Long> urlParams = new HashMap<>();
        urlParams.put("id", id);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/course-detail/{id}")
                .buildAndExpand(urlParams)
                .toUri();

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("2강"))
                .andDo(print());
    }

    @Test
    public void updateTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        CourseDetailRequest courseDetailRequest = CourseDetailRequest.builder()
                .id(3L)
                .title("2강")
                .content("JAVA 8 설치")
                .courseId(2L)
                .build();

        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/course-detail")
                .build()
                .toUri();

        mockMvc.perform(put(uri)
                .content(objectMapper.writeValueAsString(courseDetailRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("JAVA 8 설치"))
                .andDo(print());
    }

    // TODO 현재의 DELETE 테스트는 제대로된 테스트가 아닙니다. 이유를 찾아보시고 알맞게 수정해주세요.
    @Test
    public void deleteTest() throws Exception {
        Long id = 3L;

        Map<String, Long> urlParams = new HashMap<>();
        urlParams.put("id", id);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/course-detail/{id}")
                .buildAndExpand(urlParams)
                .toUri();

        mockMvc.perform(delete(uri))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
