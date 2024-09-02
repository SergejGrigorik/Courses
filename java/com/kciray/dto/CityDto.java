package com.kciray.dto;

import com.kciray.entity.address.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto {
    private int id;
    private RegionDto region;
    private String nameCity;
}
