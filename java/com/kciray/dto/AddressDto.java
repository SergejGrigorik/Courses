package com.kciray.dto;

import com.kciray.entity.address.City;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private int id;
    private CityDto city;
    private String street;
    private String house;
    private String apartment;

}
