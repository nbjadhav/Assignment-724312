package com.springboot.app.util;

/**
 * @author 724312
 *
 */
public class Constants {

	public static final String SERVER_ERROR= "Server Error";
	
	public static final String BAD_REQUEST= "Bad Request";
	
	public static final String API= "/api";
	
	public static final String SUBSCRIPTIONS= "/subscriptions";
	
	public static final String SUBSCRIPTIONS_ID= "/subscription/{id}";
	
	public static final String THREAD_TIME_OUT = "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds";
	
	public static final String ERROR_THRESHOLD= "hystrix.command.default.circuitBreaker.errorThresholdPercentage";
	
	public static final String ISOLATION_STATEGY = "hystrix.command.default.execution.isolation.strategy";
	
	public static final String REQUEST_VALUME_THRESHOLD = "hystrix.command.default.circuitBreaker.requestVolumeThreshold";
}
