package com.kciray.model;

import com.kciray.model.status.CourierStatus;
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
public class Courier implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "courier_status")
    @Enumerated(value = EnumType.STRING)
    private CourierStatus courierStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_user_id")
    private User user;


}
