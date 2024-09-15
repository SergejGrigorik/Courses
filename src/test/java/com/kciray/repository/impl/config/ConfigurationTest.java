package com.kciray.repository.impl.config;

import com.kciray.configuration.ApplicationConfiguration;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@TestPropertySource("classpath:database.properties")


public class ConfigurationTest {


}
