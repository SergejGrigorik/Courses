package com.kciray.entity.menu;

import com.kciray.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class Pfcc implements BaseEntity<Integer> {
    private Integer id;
    private double proteins;
    private double fats;
    private double calories;
    private double carbohydrates;
}
