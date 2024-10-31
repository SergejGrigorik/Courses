package com.kciray.controller;

import com.kciray.dto.UserDto;
import com.kciray.dto.entityfilter.UserFilter;
import com.kciray.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping("/page")
    public Page<UserDto> findAllBy(Pageable pageable) {
        return userService.findAllBy(pageable);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping("/filter")
    public List<UserDto> findAllByFilter(@ParameterObject UserFilter userFilter) {
        return userService.findAllByFilter(userFilter);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto create(@RequestBody  UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") Integer id, @RequestBody @Valid  UserDto userDto) {
        return userService.update(id, userDto);
    }

    @PreAuthorize("hasRole('DELETE_USER')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);
    }


}
