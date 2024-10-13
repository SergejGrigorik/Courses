package com.kciray.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring")
public record DatabaseProperties( String url,
        String username,
        String password,
        String driver) {


}
