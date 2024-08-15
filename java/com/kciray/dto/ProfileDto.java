package com.kciray.dto;

import com.kciray.entity.address.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileDto {
    private int id;
    private String firstName;
    private String lastName;
    private int number;
    private AddressDto address;

}
