package com.kciray.dto;

import com.kciray.model.Courier;
import com.kciray.model.Restaurant;
import com.kciray.model.address.Address;
import com.kciray.model.order.Order;
import com.kciray.model.status.StatusLookCourier;
import com.kciray.validated.Create;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDto {

    private Integer id;
    @NotNull(groups = {Default.class , Create.class})
    private Order order;

    private Courier courier;
    @NotNull(groups = {Default.class , Create.class})
    private LocalDate deliveryDate;
    @NotNull(groups = {Default.class , Create.class})
    private LocalTime deliveryTime;
    @NotNull(groups = {Default.class , Create.class})
    private Address deliveryAddress;
    @NotNull(groups = {Default.class , Create.class})
    private Restaurant restaurant;

    private StatusLookCourier lookCourier;
}
