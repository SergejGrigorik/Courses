package com.kciray.model.status;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum  implements GrantedAuthority{
    ADMINISTRATOR, COURIER, USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
