package com.ideal.idealmaker.exception;

public class IllegalExtensionException extends RuntimeException{

    public IllegalExtensionException(ExceptionMessage msg) {
        super(msg.getMessage());
    }
}
