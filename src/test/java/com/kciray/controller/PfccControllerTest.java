package com.kciray.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kciray.controller.config.ConfigurationControllerTest;
import com.kciray.dto.menu.PfccDto;
import com.kciray.service.PfccService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RequiredArgsConstructor
class PfccControllerTest extends ConfigurationControllerTest {

    private final Integer id = 1;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;
    @InjectMocks
    @Autowired
    private final PfccController pfccController;
    @Mock
    private PfccService pfccService;
    private MockMvc mockMvc;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pfccController).build();
    }

    @Test
    void createPfcc() throws Exception {
        PfccDto pfccDto = PfccDto.builder()
                .fats(23.0)
                .calories(23.0)
                .carbohydrates(123.0)
                .proteins(12.0)
                .build();
        Mockito.doNothing().when(pfccService).create(pfccDto);

        mockMvc.perform(
                        post("/api/v1/pfcc")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(pfccDto))
                                .accept(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }


    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/pfcc"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON_VALUE)
                );
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/api/v1/pfcc/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.proteins").value(12))
                .andExpect(jsonPath("$.fats").value(12))
                .andExpect(jsonPath("$.calories").value(34))
                .andExpect(jsonPath("$.carbohydrates").value(100));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

}