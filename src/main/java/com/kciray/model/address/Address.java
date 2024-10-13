package com.kciray.model.address;

import com.kciray.model.BaseEntity;
import com.kciray.model.Profile;
import com.kciray.model.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"city", "restaurants", "profile"})
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Address address = (Address) object;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house, address.house) && Objects.equals(apartment, address.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, apartment);
    }
}
