package com.springboot.app.service;

import java.util.List;

import com.springboot.app.model.Subscription;

/**
 * This is the service layer which holds business logic and configuration with
 * other services
 */
public interface SubscriptionService {

	public Subscription findSubscription(int id);
	public List<Subscription> findAllSubscriptions();
	public Subscription saveSubscription(Subscription subscription);
	public Subscription updateSubscription(Subscription subscription);
}
