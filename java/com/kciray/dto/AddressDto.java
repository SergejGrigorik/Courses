package com.kciray.dto;

import com.kciray.entity.address.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private int id;
    private CityDto city;
    private String street;
    private String house;
    private String apartment;

}
