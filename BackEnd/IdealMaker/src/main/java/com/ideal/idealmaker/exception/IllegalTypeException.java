package com.ideal.idealmaker.exception;

public class IllegalTypeException extends RuntimeException{

    public IllegalTypeException(ExceptionMessage msg) {
        super(msg.getMessage());
    }
}
