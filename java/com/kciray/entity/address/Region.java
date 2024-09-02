package com.kciray.entity.address;

import com.kciray.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Region implements BaseEntity<Integer> {
    private Integer id;
    private String nameRegion;
}
