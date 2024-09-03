package com.kciray.connection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
class ConnectionFactory {
    @Getter
    private final int size = 5;
    @Autowired
    DataSource dataSource;
    @Getter
    private Map<Connection, Boolean> freeConnection =  new ConcurrentHashMap<>();

    public ConnectionFactory() {

    }


    public void createConnectionPool() {
        for (int i = 0; i < size; i++) {
            freeConnection.put(openConnection(), true);
        }
    }

    public Connection createConnection() {
        freeConnection.put(openConnection(), false);
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