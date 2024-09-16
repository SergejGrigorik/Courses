package com.kciray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private Integer id;
    private CityDto city;
    private String street;
    private String house;
    private String apartment;

}
