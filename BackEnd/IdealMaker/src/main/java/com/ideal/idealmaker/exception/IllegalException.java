package com.ideal.idealmaker.exception;

public class IllegalException extends RuntimeException{

	public IllegalException(ExceptionMessage msg) {
		super(msg.getMessage());
	}
}
