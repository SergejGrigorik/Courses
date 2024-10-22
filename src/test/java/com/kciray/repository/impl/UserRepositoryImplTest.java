package com.kciray.repository.impl;

import com.kciray.dto.UserDto;
import com.kciray.model.User;
import com.kciray.repository.UserRepository;
import com.kciray.repository.impl.config.ConfigurationRepositoryTest;
import com.kciray.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
class UserRepositoryImplTest  extends ConfigurationRepositoryTest {

    private final UserRepository repository;
    private final UserService userService;

    @Transactional
    @Test
    void findAll() {
        List<User> all = repository.findAll();
        List<UserDto> all1 = userService.findAll();
        System.out.println(all);
        System.out.println(all1);
    }
    @Transactional
    @Test
    void findByRep(){
        Optional<User> byId = repository.findById(1);
        System.out.println(byId);
    }

    @Transactional
    @Test
    void findByServ(){
        UserDto byId = userService.findById(1);
        System.out.println(byId);
    }
}