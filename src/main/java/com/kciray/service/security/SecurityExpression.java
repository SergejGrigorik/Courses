package com.kciray.service.security;

import com.kciray.dto.UserDto;
import com.kciray.model.Role;
import com.kciray.model.User;
import com.kciray.model.status.RoleEnum;
import org.springframework.stereotype.Component;

@Component
public class SecurityExpression {

    public boolean checkGetUserPermissions(User principal, UserDto userDto) {
        Role principalRole = principal.getRole();
        if (principalRole.getRole() == RoleEnum.ADMINISTRATOR) return true;
        return principalRole.getRole() == RoleEnum.USER && userDto.getId().equals(principal.getId());
    }
}
