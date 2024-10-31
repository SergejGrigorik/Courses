package com.kciray.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {

    private Integer id;

    @NotNull
    private ProfileDto profile;

    @NotNull
    @Size(min = 5, max = 50, message = "Username must contain from 5 to 50 characters")
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email(message = "Email address must be in the format user@example.com")
    @Size(min = 5, max = 255, message = "Password length must be no more than 255 characters\"")
    private String email;

    private RoleDto role;
}
