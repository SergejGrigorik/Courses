package com.kciray.controller.security;

import com.kciray.dto.dtoSecurity.JwtAuthenticationResponse;
import com.kciray.dto.dtoSecurity.UserDtoInRequest;
import com.kciray.dto.dtoSecurity.UserDtoUpRequest;
import com.kciray.service.security.AuthenticationService;
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
@Tag(name = "Authentication")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "User registration")
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid UserDtoUpRequest request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "User Authorization")
    @PostMapping("/sign-in")

    public JwtAuthenticationResponse signIn(@RequestBody @Valid UserDtoInRequest request) {
        return authenticationService.signIn(request);
    }
}

