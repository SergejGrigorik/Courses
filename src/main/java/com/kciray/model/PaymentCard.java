package com.kciray.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "payment_card")
public class PaymentCard implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cardHolder;

    @Column(name = "number_card")
    private String cardNumber;

    @Column(name = "valid_thru")
    private String expiryDate;

    @Column(name = "security_code")
    private String cvv;
}
