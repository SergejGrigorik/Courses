package com.kciray.repository;

import com.kciray.dto.address.AddressDto;
import com.kciray.model.address.Address;
import com.kciray.model.address.City;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Address a set a.city = :city, a.street = :street, a.house = :house, a.apartment = :apartment where a.id = :id")
    Optional<AddressDto> update(Integer id, City city, String street, String house, String apartment);

    @EntityGraph(attributePaths = {"city", "city.region"})
    Optional<Address> findById(Integer id);
}
