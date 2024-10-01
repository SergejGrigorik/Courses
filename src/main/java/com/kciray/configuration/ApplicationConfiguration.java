package com.kciray.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = true)
public class ApplicationConfiguration {
}
