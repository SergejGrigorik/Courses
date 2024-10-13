package com.kciray.dto;

import com.kciray.model.status.RoleEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoleDto {

    private Integer id;

    @NotNull
    private RoleEnum role;
}
