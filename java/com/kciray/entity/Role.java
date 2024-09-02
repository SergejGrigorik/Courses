package com.kciray.entity;

import com.kciray.entity.status.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Role {
    private int id;
    private RoleEnum role;

}
