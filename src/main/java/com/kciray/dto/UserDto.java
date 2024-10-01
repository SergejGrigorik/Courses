package com.kciray.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kciray.model.Role;
import com.kciray.model.status.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(description = "Запрос на аутентификацию")
public class UserDto {
//    private Integer id;
    private ProfileDto profile;
    private String username;
    private String password;
    private String email;
    private RoleEnum role;
}
