package com.kciray.model.status;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum  implements GrantedAuthority{
    ADMINISTRATOR, COURIER, USER,OPERATOR;

    @Override
    public String getAuthority() {
        return name();
    }

    @Getter
    public static class Constants{

        public static final String ADMINISTRATION = "ADMINISTRATION";

        public Constants() {
        }
    }
}
