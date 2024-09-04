package com.kciray.dto;

import com.kciray.entity.Profile;
import com.kciray.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class UserDto {
    private  int id ;
    private ProfileDto profile;
    private String password;
    private String login;
    private Role role;
}
