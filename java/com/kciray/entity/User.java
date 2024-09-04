package com.kciray.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class User implements BaseEntity<Integer> {
    private  Integer id ;
    private Profile profile;
    private String password;
    private String login;
    private Role role;

}
