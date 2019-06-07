package com.springboot.app.exception;

public class SubscriptionNotFoundException extends RuntimeException  {

	public SubscriptionNotFoundException(String exception) {
	    super(exception);
	  }
}
