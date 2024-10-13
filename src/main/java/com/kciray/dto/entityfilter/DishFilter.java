package com.kciray.dto.entityfilter;

import java.math.BigDecimal;

public record DishFilter(String name,
                         BigDecimal fromPrice,
                         BigDecimal toPrice,
                         Integer discount,
                         Double fromWeight,
                         Double toWeight,
                         Integer restaurantId,
                         Integer categoryId
) {
}


