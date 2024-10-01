package com.kciray.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(description =
        "Authentication Request")
public class UserDtoInRequest {
    @Schema(description = "Username", example = "Jonotan")
    @Size(min = 5, max = 50, message =
            "Username must be between 5 and 50 characters")
    @NotBlank(message =
            "Username cannot be empty")
    private String username;
    @Schema(description = "Password", example = "my_1secret1_password")
    @Size(min = 8, max = 255, message = "Password length must be between 8 and 255 characters")
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
