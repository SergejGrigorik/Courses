package com.kciray.exception;

public class MissingDishException extends RuntimeException{

    public MissingDishException(String message){
        super(message);
    }
}
