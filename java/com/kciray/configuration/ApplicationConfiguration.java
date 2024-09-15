package com.kciray.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import liquibase.integration.spring.SpringLiquibase;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;


@Configuration(proxyBeanMethods = true)
@ComponentScan(basePackages = "com.kciray")
@PropertySource("classpath:database.properties")
//@EnableJpaRepositories
@EnableTransactionManagement

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
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.kciray");
        em.setPersistenceUnitName("entityManager");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(false);
        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();

        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.show-sql", environment.getProperty("jdbc.show-sql"));
        properties.put("hibernate.ddl-auto", environment.getProperty("hibernate.ddl-auto"));
        properties.put("generate-ddl", environment.getProperty("generate-ddl"));
        properties.put("hibernate.defer-datasource-initialization", environment.getProperty("hibernate.defer-datasource-initialization"));


        em.setJpaPropertyMap(properties);
        return em;
    }


    @Bean()
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }


    @Bean
    public SpringLiquibase springLiquibase(DataSource dataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog("db/changelog/changelog.xml");
        springLiquibase.setDataSource(dataSource);
        return springLiquibase;
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