package com.kciray.model;


import com.kciray.model.status.StatusBusyCourier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "schedule_courier_for_day")
public class ScheduleCourierForDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_courier_id")
    private ScheduleCourier scheduleCourier;

    @Column(name = "working_hours_from")
    private LocalTime workingHoursFrom;

    @Column(name = "working_hours_to")
    private LocalTime workingHoursTo;

    private String day;

    @Column(name = "busy")
    @Enumerated(value = EnumType.STRING)
    private StatusBusyCourier statusBusyCourier;

}
