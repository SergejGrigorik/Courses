package com.kciray.model;

import com.kciray.model.address.Address;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.annotation.MergedAnnotation;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = "address")
@EqualsAndHashCode(exclude = "address")
@Entity
public class Profile implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "number")
    private long number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

}
