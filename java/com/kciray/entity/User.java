package com.kciray.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private  int id ;
    private Profile profile;
    private int password;
    private String login;
    private Role role;

}
