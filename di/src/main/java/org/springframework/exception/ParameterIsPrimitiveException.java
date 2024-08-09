package org.springframework.exception;

public class ParameterIsPrimitiveException extends RuntimeException{
    public ParameterIsPrimitiveException(String message){
        super(message);
    }
}
