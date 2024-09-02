package com.kciray.dao.impl;


import com.kciray.connection.ConnectionPool;
import com.kciray.dao.Dao;
import com.kciray.dao.UserDao;
import com.kciray.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao, Dao<Integer, User> {
    private final String FIND_BY_ID = "select * from \"user\" where id = ?";
    private final String SAVE_SQL = "insert into \"user\"(id,profile_id,password,login,role_id) values(?,?,?,?,?)";
    private final String DELETE_SQL = "delete from \"user\" where id = ?";
    private final String UPDATE_SQL = """ 
              update \"user\" 
              set 
               profile_id = ?,
               password = ?,
               login = ?,
               role_id = ?                  
              where id = ?
            """;
    private final String FIND_ALL_SQL = "select * from \"user\"";
    private final ConnectionPool connectionPool;
    private final ProfileDaoImpl profileDao;
    private final RoleDaoImpl roleDao;

    @Autowired
    public UserDaoImpl(ConnectionPool connectionPool, ProfileDaoImpl profileDao, RoleDaoImpl roleDao) {
        this.connectionPool = connectionPool;
        this.profileDao = profileDao;
        this.roleDao = roleDao;
    }

    @Override

    public User save(User entity) {

        try (PreparedStatement preparedStatement = connectionPool.get().prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {


            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getProfile().getId());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getLogin());
            preparedStatement.setInt(5, entity.getRole().getId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return entity;


    }


    public void update(User entity) {
        try (PreparedStatement preparedStatement = connectionPool.get().prepareStatement(UPDATE_SQL)) {
            preparedStatement.setInt(1, entity.getProfile().getId());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setInt(4, entity.getRole().getId());
            preparedStatement.setInt(5, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean delete(Integer id) {

        try (PreparedStatement preparedStatement = connectionPool.get().prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }


    public Optional<User> findById(Integer id) {
        try (PreparedStatement preparedStatement = connectionPool.get().prepareStatement(FIND_BY_ID);) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildUser(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public List<User> findAll() {
        try (PreparedStatement preparedStatement = connectionPool.get().prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(buildUser(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }


    private User buildUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                profileDao.findById(resultSet.getInt("profile_id")).get(),
                resultSet.getString("password"),
                resultSet.getString("login"),
                roleDao.findById(resultSet.getInt("role_id")).get()
        );

    }

}
