package com.fastcampus.admin.controller;

import com.fastcampus.admin.entity.ApplyCourse;
import com.fastcampus.admin.model.http.ApplyCourseRequest;
import com.fastcampus.admin.model.http.CourseRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
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
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO 해당 내용은 2차 최종과제의 1번 기능입니다.
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ApplyCourseApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Long studentId = 8L;
        Long courseId = 2L;

        ApplyCourseRequest applyCourseRequest = ApplyCourseRequest.builder()
                .studentId(studentId)
                .courseId(courseId)
                .build();

        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/apply-course")
                .build()
                .toUri();

        mockMvc.perform(post(uri)
                .content(objectMapper.writeValueAsString(applyCourseRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("REGISTERED"))
                .andDo(print());
    }

    @Test
    public void readTest() throws Exception {
        Long id = 2L;

        Map<String, Long> urlParams = new HashMap<>();
        urlParams.put("id", id);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/apply-course/{id}")
                .buildAndExpand(urlParams)
                .toUri();

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("REGISTERED"))
                .andDo(print());
    }

    @Test
    public void updateTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        ApplyCourseRequest applyCourseRequest = ApplyCourseRequest.builder()
                .id(2L)
                .progressRate(100f)
                .expireAt(LocalDateTime.now().toString())
                .isComplete(true)
                .build();

        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/apply-course")
                .build()
                .toUri();

        mockMvc.perform(put(uri)
                .content(objectMapper.writeValueAsString(applyCourseRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.progressRate").value("100.0"))
                .andDo(print());
    }

    // TODO 현재의 DELETE 테스트는 제대로된 테스트가 아닙니다. 이유를 찾아보시고 알맞게 수정해주세요.
    @Test
    public void deleteTest() throws Exception {
        Long id = 10L;

        Map<String, Long> urlParams = new HashMap<>();
        urlParams.put("id", id);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/apply-course/{id}")
                .buildAndExpand(urlParams)
                .toUri();

        mockMvc.perform(delete(uri))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
