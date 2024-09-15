package com.kciray.repository.impl;

import com.kciray.model.address.Address;
import com.kciray.repository.AddressDao;
import com.kciray.repository.RepositoryBase;
import org.hibernate.graph.GraphSemantic;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class AddressRepositoryImpl extends RepositoryBase<Integer,Address> implements AddressDao {
    public AddressRepositoryImpl() {
        super(Address.class);
    }

    @Override
    public Optional<Address> findById(Integer id) {
        Map<String,Object> properties = Map.of(GraphSemantic.LOAD.getJakartaHintName(),entityManager.getEntityGraph("WithCityAndRegion"));
        return Optional.ofNullable(entityManager.find(Address.class,id,properties));
    }


}
