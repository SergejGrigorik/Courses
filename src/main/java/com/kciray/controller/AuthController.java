package com.kciray.controller;

import com.kciray.domain.dto.JwtAuthenticationResponse;
import com.kciray.domain.model.UserDtoInRequest;
import com.kciray.domain.model.UserDtoUpRequest;
import com.kciray.dto.UserDto;
import com.kciray.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid UserDtoUpRequest request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")

    public JwtAuthenticationResponse signIn(@RequestBody @Valid UserDtoInRequest request) {
        return authenticationService.signIn(request);
    }
}

