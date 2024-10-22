package com.kciray.controller;


import com.kciray.controller.config.ConfigurationControllerTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RequiredArgsConstructor
class AddressControllerTest extends ConfigurationControllerTest {


    private final MockMvc mockMvc;
    private final Integer id = 1;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/address"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON_VALUE)
                );
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/api/v1/address/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.street").value("Pushkova"))
                .andExpect(jsonPath("$.house").value(41))
                .andExpect(jsonPath("$.apartment").value(23));
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/api/v1/address")
//                        .param("id", "21")
                        .with(csrf())
                        .param("city", "1")
                        .param("street", "21.0")
                        .param("house", "21.0")
                        .param("apartment", "21.0")
                )
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}