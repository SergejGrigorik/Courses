package com.kciray.dto;

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
    private RegionDto region;
    private String nameCity;
}
