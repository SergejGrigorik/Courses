package com.kciray.exception;

public class ConnectionPoolEmptyException extends RuntimeException{
    public ConnectionPoolEmptyException (){

    }
    public ConnectionPoolEmptyException (String message){
        super(message);

    }
}
