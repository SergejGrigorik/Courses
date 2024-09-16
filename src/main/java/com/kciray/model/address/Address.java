package com.kciray.model.address;

import com.kciray.model.BaseEntity;
import com.kciray.model.Profile;
import com.kciray.model.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "WithCityAndRegion",
        attributeNodes = {
                @NamedAttributeNode(value = "city", subgraph = "region")
        },
        subgraphs = {
                @NamedSubgraph(name = "region", attributeNodes = @NamedAttributeNode("region"))
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"city", "restaurants", "profile"})
@EqualsAndHashCode(exclude = {"city", "restaurants", "profile"})
@Builder
@Entity
public class Address implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
    private String street;
    private String house;
    private String apartment;

    @OneToMany(mappedBy = "address")
    private List<Restaurant> restaurants = new ArrayList<>();

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY, optional = false)
    private Profile profile;

}
