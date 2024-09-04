package com.kciray.dao.impl;

import com.kciray.connection.ConnectionPool;
import com.kciray.dao.Dao;
import com.kciray.dao.PfccDao;
import com.kciray.entity.menu.Pfcc;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PfccDaoImpl implements PfccDao, Dao<Integer, Pfcc> {
    String sql = "insert into pfcc values (?,?,?,?,?)";
    @Autowired

    private ConnectionPool connectionPool;


    @SneakyThrows
    @Override
    public Pfcc save(Pfcc entity) {
        Connection connection = connectionPool.getFreeConnectForThread().get();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setDouble(5, entity.getProteins());
        preparedStatement.setDouble(2, entity.getFats());
        preparedStatement.setDouble(3, entity.getCalories());
        preparedStatement.setDouble(4, entity.getCarbohydrates());
        preparedStatement.executeUpdate();

        return entity;
    }

    @Override
    public void update(Pfcc ticket) {

    }

    @Override
    public Optional<Pfcc> findById(Integer id) {
        Pfcc pfcc = null;
        try {
            PreparedStatement preparedStatement = connectionPool.getFreeConnectForThread().get().prepareStatement("SELECT * FROM pfcc WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            pfcc = new Pfcc();
            pfcc.setId(resultSet.getInt("id"));
            pfcc.setProteins(resultSet.getDouble("proteins"));
            pfcc.setFats(resultSet.getDouble("fats"));
            pfcc.setCalories(resultSet.getDouble("calories"));
            pfcc.setCarbohydrates(resultSet.getDouble("carbohydrates"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(pfcc);
    }

    @Override
    public List<Pfcc> findAll() {
        return List.of();
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connectionPool.getFreeConnectForThread().get().prepareStatement("DELETE FROM pfcc WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }


    }

}
