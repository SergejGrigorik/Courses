package com.kciray.connection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
class ConnectionFactory {
    @Autowired
    DataSource dataSource;
    @Getter
    private Map<Connection, Boolean> mapFreeConnection =  new ConcurrentHashMap<>();

    public ConnectionFactory() {

    }

    public void createConnectionPool(Integer size) {
        for (int i = 0; i < size; i++) {
            mapFreeConnection.put(openConnection(), true);
        }
    }

    public Connection createConnection() {
        mapFreeConnection.put(openConnection(), false);
        return openConnection();
    }


    private Connection openConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}