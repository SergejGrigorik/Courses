package com.kciray.controller.config;

import com.kciray.repository.impl.config.annotation.IT;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;

@IT
@AutoConfigureMockMvc()
@WithMockUser(username = "test@gmail.com",authorities = {"ADMINISTRATOR","COURIER","USER","OPERATOR"})
public class ConfigurationControllerTest {
}
