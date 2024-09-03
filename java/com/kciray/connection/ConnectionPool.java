package com.kciray.connection;

import com.kciray.exception.EmptyConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ConnectionPool {

    @Autowired
    private ConnectionFactory connectionFactory;

    private Map<Connection, Boolean> mapFreeConnection = new ConcurrentHashMap<>();
    private ThreadLocal<Connection> connectionForThread = new ThreadLocal<>();


    private Connection getFreeConnection() {
        for (var map : mapFreeConnection.entrySet()) {
            map.getValue().equals(true);
            map.setValue(false);
            return map.getKey();
        }
        Connection connection = connectionFactory.createConnection();
        return connection;
    }

    public ThreadLocal<Connection> getConnectionForThread() {
        if (mapFreeConnection.isEmpty()) {
            connectionFactory.createConnectionPool();
            mapFreeConnection.putAll(connectionFactory.getFreeConnection());

        }

        if (connectionForThread.get() == null) {
            setThreadLocal();
        }
        return connectionForThread;
    }

    private void setThreadLocal() {
        connectionForThread.set(getFreeConnection());
    }


    public Boolean isValidateConnection() {
        if (mapFreeConnection.get(connectionForThread.get()).equals(true) || !mapFreeConnection.containsKey(connectionForThread.get()) || connectionForThread.get() == null) {
            throw new EmptyConnectionException("The connection was closed. Connection in transaction cannot be empty");
        }
        return true;
    }

    public void closeConnection() {
        Connection connection = connectionForThread.get();
        if (mapFreeConnection.size() < connectionFactory.getSize()) {
            mapFreeConnection.put(connection, true);
            connectionForThread.remove();
        } else {
            try {
                connection.close();
                mapFreeConnection.remove(connection);
                connectionForThread.remove();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void closePool() {
        for (Connection connection : mapFreeConnection.keySet()) {

            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        mapFreeConnection.clear();
    }

}


//
//BaseConnection AbstractJdbc2Connection = null;
//
//                      AbstractJdbc2Connection.getTransactionState().equals(TransactionState.IDLE);


//    public ThreadLocal<Connection> getFreeConnectForThread(){
//        connectionWithOutTransaction.set(getFreeConnection());
//        return  connectionWithOutTransaction;
//    }
//
//    public ThreadLocal<Connection> getFreeConnectWithTransactionForThread(){
//        connectionWithOutTransaction.set(getFreeConnection());
//        return  connectionWithOutTransaction;
//    }


//private final class ConnectionFactory {
//
//    private final int size = 5;
//    private Map<Connection, Boolean> freeConnection;
//
//    public ConnectionFactory() {
//
//    }
//
//    private void createConnectionPool() {
//        for (int i = 0; i < size; i++) {
//            freeConnection.put(openConnection(), true);
//        }
//    }
//
//    private Connection createConnection() {
//        freeConnection.put(openConnection(), false);
//        return openConnection();
//    }
//
//
//    private Connection openConnection() {
//        try {
//            return dataSource.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//
//}