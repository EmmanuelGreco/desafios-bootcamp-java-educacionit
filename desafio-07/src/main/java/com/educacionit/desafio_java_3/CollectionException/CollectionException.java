package com.educacionit.desafio_java_3.CollectionException;

public class CollectionException extends Exception {

	public CollectionException() {

	}

	public CollectionException(String message) {
		super(message);
	}

	public CollectionException(Throwable cause) {
		super(cause);
	}

	public CollectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public CollectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
