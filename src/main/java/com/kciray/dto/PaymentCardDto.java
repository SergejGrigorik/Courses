package com.kciray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCardDto {
    private String cardHolder;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
