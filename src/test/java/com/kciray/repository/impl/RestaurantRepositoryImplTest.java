package com.kciray.repository.impl;

import com.kciray.model.Restaurant;
import com.kciray.repository.impl.config.ConfigurationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryImplTest extends ConfigurationTest {
    @Autowired
    public RestaurantRepositoryImpl repository;
    private final int id = 1;

    @Test
    void findById() {
        Optional<Restaurant> byId = repository.findById(id);
        assertTrue(byId.isPresent());
        assertThat(byId.get().getId()).isEqualTo(id);
    }

    @Test
    void findAll() {
        int id1 = 1;
        int id2 = 2;
        int id3 = 3;
        List<Restaurant> all = repository.findAll();
        assertNotNull(all);
        List<Integer> list = all.stream().map(Restaurant::getId).toList();
        assertThat(list).contains(id1, id2, id3);
    }


    @Test
    void findAddressAndRestaurantById(){
        try {

            Restaurant addressAndRestaurantById = repository.findAddressAndRestaurantById(id);
            assertNotNull(addressAndRestaurantById);
            assertThat(addressAndRestaurantById.getId()).isEqualTo(id);
            addressAndRestaurantById.getAddress().getStreet();
            assertThat(true).isTrue();
        }catch (Exception e) {
            assertThat(true).isFalse();
        }
    }

}