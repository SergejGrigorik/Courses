package com.kciray.dto;

import com.kciray.model.Role;
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
    private ProfileDto profile;
    private String password;
    private String login;
    private Role role;
}
