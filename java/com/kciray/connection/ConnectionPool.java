package com.kciray.connection;

import com.kciray.exception.ConnectionCloseException;
import com.kciray.exception.ConnectionPoolEmptyException;
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
    private ThreadLocal<Boolean> isActiveTransaction = new ThreadLocal<>();
    private Integer sizeConnection = 5;


    private Connection getFreeConnection() {
        if (mapFreeConnection.isEmpty()) {
            connectionFactory.createConnectionPool(sizeConnection);
            mapFreeConnection.putAll(connectionFactory.getMapFreeConnection());

        }
        for (Connection connect : mapFreeConnection.keySet()){
            if (connect == null){
                mapFreeConnection.remove(null);
                mapFreeConnection.put(connectionFactory.createConnection(),false);
            }
        }

        Connection connection = null;
        for (var map : mapFreeConnection.entrySet()) {
            if (map.getValue().equals(true)) {
                map.setValue(false);
                connection = map.getKey();
                return connection;
            }
        }
        if (connection == null) {
            throw new ConnectionPoolEmptyException("No free connection");
        }
        return connection;
    }

    public ThreadLocal<Connection> getFreeConnectForThread(){
        if (isActiveTransaction.get() == null){
            isActiveTransaction.set(false);
        }
        if (connectionForThread.get() == null && isActiveTransaction.get() == true){
            throw new ConnectionCloseException("The connection with the transaction was closed");
        }
        if (connectionForThread.get() != null && (isActiveTransaction.get() == true || isActiveTransaction.get() == false )){
            return connectionForThread;
        }
        if (connectionForThread.get() == null && isActiveTransaction.get() == false) {
            setThreadLocal();
        }
        return connectionForThread;
    }

    private void setThreadLocal() {
        isActiveTransaction.set(false);
        connectionForThread.set(getFreeConnection());
    }
    public void setThreadLocalActiveTransaction(){
        isActiveTransaction.set(true);
    }


    public Boolean isValidateConnection() {
        if (mapFreeConnection.get(connectionForThread.get()).equals(true) || !mapFreeConnection.containsKey(connectionForThread.get()) || connectionForThread.get() == null) {
            throw new ConnectionCloseException("The connection was closed. Connection in transaction cannot be empty");
        }
        return true;
    }

    public void closeConnection() {
        Connection connection = connectionForThread.get();
        mapFreeConnection.put(connection, true);
        isActiveTransaction.set(false);
        connectionForThread.remove();
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