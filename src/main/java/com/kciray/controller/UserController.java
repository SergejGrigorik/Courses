package com.kciray.controller;

import com.kciray.dto.UserDto;
import com.kciray.dto.entityfilter.UserFilter;
import com.kciray.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/page")
    public Page<UserDto> findAllBy(Pageable pageable) {
        return userService.findAllBy(pageable);
    }

    @GetMapping("/filter")
    public List<UserDto> findAllByFilter(@ParameterObject UserFilter userFilter) {
        return userService.findAllByFilter(userFilter);
    }


    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") Integer id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);
    }


}
