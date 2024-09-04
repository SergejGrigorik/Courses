package com.kciray.exception;

public class ConnectionCloseException extends RuntimeException {

    public ConnectionCloseException(String message){
        super(message);
    }
    public ConnectionCloseException(){

    }
}
