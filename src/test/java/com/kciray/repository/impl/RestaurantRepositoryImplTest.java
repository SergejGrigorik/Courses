package com.kciray.repository.impl;

import com.kciray.model.Restaurant;
import com.kciray.repository.RestaurantRepository;
import com.kciray.repository.impl.config.ConfigurationTest;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RestaurantRepositoryImplTest extends ConfigurationTest {
    private final int id = 1;
    @Autowired
    public RestaurantRepository repository;

    @Test
    void findById() {
        Optional<Restaurant> byId = repository.findById(id);
        assertTrue(byId.isPresent());
        assertThat(byId.get().getId()).isEqualTo(id);
    }

    @Test
    void findAll() {
        Set<Integer> setId = Set.of(1, 2, 3);
        List<Restaurant> all = repository.findAll();
        assertNotNull(all);
        List<Integer> list = all.stream().map(Restaurant::getId).toList();
        assertThat(list).contains(setId.stream().iterator().next());
    }


    @Test
    void findAddressAndRestaurantById() {
        try {

            Restaurant addressAndRestaurantById = repository.findAddressAndRestaurantById(id);
            assertNotNull(addressAndRestaurantById);
            assertThat(addressAndRestaurantById.getId()).isEqualTo(id);
            addressAndRestaurantById.getAddress().getStreet();
            assertThat(true).isTrue();
        } catch (Exception e) {
            assertThat(true).isFalse();
        }
    }

}