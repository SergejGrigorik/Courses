package com.kciray.dto.address;

import com.kciray.dto.menu.RegionDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto {
    private Integer id;

    @NotNull
    private RegionDto region;

    @NotNull
    private String nameCity;
}
