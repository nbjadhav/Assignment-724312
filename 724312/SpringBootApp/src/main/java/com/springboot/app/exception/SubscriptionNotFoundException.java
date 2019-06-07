package com.springboot.app.exception;

/**
 * 
 * This class is the custom exception class which handles custom excetion from application
 *
 */
public class SubscriptionNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public SubscriptionNotFoundException(String exception) {
		super(exception);
	  }
}
