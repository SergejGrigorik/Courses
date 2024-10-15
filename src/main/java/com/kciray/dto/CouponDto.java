package com.kciray.dto;

import com.kciray.model.Restaurant;
import com.kciray.model.status.Validity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CouponDto {
    private Integer id;
    @NotNull
    private Restaurant restaurant;
    @NotNull
    private String promoCode;
    @NotNull
    private Validity validity;
    @NotNull
    private Integer discount;
}
