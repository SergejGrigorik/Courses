package com.kciray.model;

import com.kciray.model.Courier;
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
@Table(name = "schedule_courier")
public class ScheduleCourier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Column(name = "working_hours_from")
    private String workingHoursFrom;

    @Column(name = "working_hours_to")
    private String workingHoursTo;

    @Enumerated(value = EnumType.STRING)
    private Day day;

}
