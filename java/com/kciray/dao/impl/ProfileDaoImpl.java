package com.kciray.dao.impl;

import com.kciray.dao.Dao;
import com.kciray.dao.ProfileDao;
import com.kciray.entity.Profile;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfileDaoImpl  implements ProfileDao, Dao<Integer,Profile> {

    private final String FIND_BY_ID = """
                        select 
                id,
            first_name,
                last_name,
                number,
                address_id
                        from  profile where id = ?
                        """;
    @Autowired
    private ConnectionHolder connectionHolder ;


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Profile save(Profile ticket) {
        return null;
    }

    @Override
    public void update(Profile ticket) {

    }

    @SneakyThrows
    public Optional<Profile> findById(Integer id) {
        Profile profile = null;

        PreparedStatement preparedStatement = connectionHolder.getConnection().prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                profile = new Profile(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getLong("number"),
                        resultSet.getInt("address_id")
                );
            }
            return Optional.ofNullable(profile);


    }

    @Override
    public List<Profile> findAll() {
        return List.of();
    }
}
