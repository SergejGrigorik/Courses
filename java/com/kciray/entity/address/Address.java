package com.kciray.entity.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {
    private int id;
    private City city;
    private String street;
    private String house;
    private String apartment;

}
