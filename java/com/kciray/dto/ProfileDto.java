package com.kciray.dto;

import com.kciray.entity.address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {
    private int id;
    private String firstName;
    private String lastName;
    private int number;
    private AddressDto address;

}
