package com.kciray.model;

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
@Table(name = "schedule_restaurant")
public class ScheduleRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "working_hours_from")
    private LocalTime workingHoursFrom;

    @Column(name = "working_hours_to")
    private LocalTime workingHoursTo;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "day_of_week")
    private Day day;


}
