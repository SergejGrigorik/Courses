package com.kciray.exception;

public class EmptyConnectionException extends RuntimeException {

    public EmptyConnectionException(String message){
        super(message);
    }
    public EmptyConnectionException(){

    }
}
