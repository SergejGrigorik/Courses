package com.kciray.dao.impl;

import com.kciray.dao.Dao;
import com.kciray.entity.Role;
import com.kciray.entity.status.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public class RoleDaoImpl  implements RoleDao, Dao<Integer, Role> {

    private final String FIND_BY_ID = "select * from  role where id = ?";
    @Autowired
    private ConnectionHolder connectionHolder;



    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Role save(Role ticket) {
        return null;
    }

    @Override
    public void update(Role ticket) {

    }

    @Override
    public Optional<Role> findById(Integer id) {
        Role role = null;
        try (PreparedStatement preparedStatement = connectionHolder.getConnection().prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = new Role(
                        resultSet.getInt("id"),
                       RoleEnum.valueOf(resultSet.getString("role"))
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(role);
    }

    @Override
    public List<Role> findAll() {
        return List.of();
    }
}
