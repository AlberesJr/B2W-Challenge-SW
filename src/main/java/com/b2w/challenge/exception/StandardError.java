package com.b2w.challenge.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private String timestamp;
	private int status;
	private String error;
	private String menssage;
	
	public StandardError() {}
	
	public StandardError(String timestamp, int status, String error, String menssage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.menssage = menssage;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMenssage() {
		return menssage;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}
	
		
}
