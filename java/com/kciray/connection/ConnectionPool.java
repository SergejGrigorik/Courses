package com.kciray.connection;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

@Component
public final class ConnectionPool {
    @Autowired
    private DataSource dataSource;
    private Map<String, Connection> connectionForThread = new ConcurrentHashMap<>();
    private ThreadLocal<Map<String, Connection>> threadLocal = new ThreadLocal<>();


    private ConnectionPool() {

    }



    @SneakyThrows
    public Connection get() {

        if (connectionForThread.get(Thread.currentThread().getName()) == null) {
            Connection conn = getConnection();
            connectionForThread.put(Thread.currentThread().getName(), conn);
            threadLocal.set(connectionForThread);
            return connectionForThread.get(Thread.currentThread().getName());
        } else {
            return connectionForThread.get(Thread.currentThread().getName());
        }

    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();

    }
    public void close() {
        for (Connection connection : connectionForThread.values()) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        connectionForThread.clear();
    }


}
















//
//BaseConnection AbstractJdbc2Connection = null;
//                        AbstractJdbc2Connection.getTransactionState().equals(TransactionState.IDLE);