package com.kciray.entity.menu;

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
public class Pfcc {
    private int id;
    private double proteins;
    private double fats;
    private double calories;
    private double carbohydrates;
}
