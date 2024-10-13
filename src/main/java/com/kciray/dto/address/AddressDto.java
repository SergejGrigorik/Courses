package com.kciray.dto.address;

import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private CityDto city;

    @NotNull
    private String street;

    @NotNull
    private String house;

    private String apartment;

}
