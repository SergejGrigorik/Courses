package com.kciray.entity;

import com.kciray.entity.address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Profile {
    private int id;
    private String firstName;
    private String lastName;
    private int number;
    private Address address;

}
