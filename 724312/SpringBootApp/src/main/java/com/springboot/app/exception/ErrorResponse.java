package com.springboot.app.exception;

import java.util.Date;
import java.util.List;

public class ErrorResponse {

	public ErrorResponse(String message, Date timestamp, List<String> details) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}

	private String message;
	
	private Date timestamp;

	private List<String> details;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
