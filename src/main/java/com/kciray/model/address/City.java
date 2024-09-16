package com.kciray.model.address;

import com.kciray.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "addresses")
@EqualsAndHashCode (exclude = "addresses")
@Builder
@Entity
public class City implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "name_city")
    private String nameCity;


    @OneToMany(mappedBy = "city")
    private List<Address> addresses = new ArrayList<>();
}

