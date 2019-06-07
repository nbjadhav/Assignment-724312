package com.springboot.app.util;

/**
 * @author 724312
 *
 */
public class Constants {

	/*
	 * Private constructor to hide implicit public one
	 */
	private Constants() {

	}

	public static final String SERVER_ERROR = "Server Error";

	public static final String BAD_REQUEST = "Bad Request";

	public static final String API = "/api";

	public static final String SUBSCRIPTIONS = "/subscriptions";

	public static final String SUBSCRIPTIONS_ID = "/subscription/{id}";

	public static final String THREAD_TIME_OUT = "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds";

	public static final String ERROR_THRESHOLD = "hystrix.command.default.circuitBreaker.errorThresholdPercentage";

	public static final String ISOLATION_STATEGY = "hystrix.command.default.execution.isolation.strategy";

	public static final String REQUEST_VALUME_THRESHOLD = "hystrix.command.default.circuitBreaker.requestVolumeThreshold";
	
	public static final String ADMIN = "ADMIN";
	
	public static final String USER = "USER";
	
	public static final String DATA_NOT_FOUND = " Data not found";
	
	public static final String SUBSCRIPTION_NOT_FOUND = "Subscription Not Found";
}
