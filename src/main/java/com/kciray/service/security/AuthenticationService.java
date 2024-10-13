package com.kciray.service.security;

import com.kciray.domain.dto.JwtAuthenticationResponse;

import com.kciray.domain.model.UserDtoInRequest;
import com.kciray.domain.model.UserDtoUpRequest;
import com.kciray.dto.UserDto;
import com.kciray.model.User;
import com.kciray.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    public JwtAuthenticationResponse signUp(UserDtoUpRequest request) {

        UserDto userDto = UserDto.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        User user = modelMapper.map(userService.create(userDto), User.class);

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse signIn(UserDtoInRequest userDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getUsername(),
                userDto.getPassword()
        ));

        UserDetails userDetails = userService
                .userDetailsService()
                .loadUserByUsername(userDto.getUsername());

        var jwt = jwtService.generateToken(userDetails);
        return new JwtAuthenticationResponse(jwt);
    }
}
