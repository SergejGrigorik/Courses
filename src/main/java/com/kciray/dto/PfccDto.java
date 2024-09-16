package com.kciray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class PfccDto implements PfccDtoIntef{
    private Integer id;
    private Double proteins;
    private Double fats;
    private Double calories;
    private Double carbohydrates;
}
