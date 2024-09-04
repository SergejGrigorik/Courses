package com.kciray.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import liquibase.integration.spring.SpringLiquibase;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import java.util.Objects;


import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;


@Configuration(proxyBeanMethods = true)
@ComponentScan(basePackages = "com.kciray")
@PropertySource("classpath:database.properties")


public class ApplicationConfiguration {


    private final Environment environment;


    @Autowired
    public ApplicationConfiguration(Environment environment) {

        this.environment = environment;

    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());

        return objectMapper;
    }




    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("driver")));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("name"));
        dataSource.setPassword(environment.getProperty("password"));
        return dataSource;
    }

    @Bean
    public SpringLiquibase springLiquibase(DataSource dataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog("db/changelog/changelog.xml");
        springLiquibase.setDataSource(dataSource);
        return springLiquibase;
    }


    @Bean
    @SneakyThrows
    public ConnectionHolder connectionHolder() {

        return new ConnectionHolder(dataSource().getConnection());
    }


}


























//    @Bean
//    public ProxyConfig proxyFactory() {
//        ProxyConfig pf = new ProxyConfig();
//        pf.setProxyTargetClass(true);
//        return pf;
//    }
//
//    @Bean
//    public ScopedProxyMode scopedProxyMode() {
//        return ScopedProxyMode.TARGET_CLASS;
//    }