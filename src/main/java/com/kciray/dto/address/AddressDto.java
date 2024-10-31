package com.kciray.dto.address;

import com.kciray.validated.Create;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
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

    @NotNull(groups = {Default.class , Create.class})
    private CityDto city;

    @NotNull(groups = {Default.class , Create.class})
    private String street;

    @NotNull(groups = {Default.class , Create.class})
    private String house;

    private String apartment;

}
