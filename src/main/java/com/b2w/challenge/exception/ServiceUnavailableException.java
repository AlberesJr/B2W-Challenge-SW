package com.b2w.challenge.exception;

public class ServiceUnavailableException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServiceUnavailableException(String msg) {
		super(msg);
	}
}