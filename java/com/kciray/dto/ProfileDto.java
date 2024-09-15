package com.kciray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private long number;
    private AddressDto address;

}
