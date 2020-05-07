package com.fastcampus.admin.controller;

import com.fastcampus.admin.model.enumclass.StudentStatus;
import com.fastcampus.admin.model.http.StudentRequest;
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

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class StudentApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        StudentRequest studentRequest = StudentRequest.builder()
                .account("student01")
                .email("student01@gmail.com")
                .password("student01")
                .phoneNumber("010-1111-1111")
                .build();

        URI uri = UriComponentsBuilder.newInstance()
                .path("/v1/student")
                .build()
                .toUri();

        mockMvc.perform(post(uri)
                .content(objectMapper.writeValueAsString(studentRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(StudentStatus.REGISTERED.toString()))
                .andDo(print());
    }
}
