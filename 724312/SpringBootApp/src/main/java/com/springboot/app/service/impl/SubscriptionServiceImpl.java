
package com.springboot.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.dao.SubscriptionDao;
import com.springboot.app.exception.SubscriptionNotFoundException;
import com.springboot.app.model.Subscription;
import com.springboot.app.service.SubscriptionService;
import com.springboot.app.util.Constants;

/**
 * This is the service layer which holds business logic and configuration with
 * other services
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	private static final Logger LOGGER = LogManager.getLogger(SubscriptionServiceImpl.class);

	@Autowired
	private SubscriptionDao subscriptionDao;

	/**
	 * This method gets single subscription for the provided subscription Id
	 */
	@Override
	public Subscription findSubscription(int id) {

		LOGGER.info("Inside SubscriptionServiceImpl findSubscription method");
		Subscription subsctn;
		Optional<Subscription> subscription = subscriptionDao.findById(id);

		if (subscription.isPresent()) {
			subsctn = subscription.get();
		} else {
			throw new SubscriptionNotFoundException(Constants.SUBSCRIPTION_NOT_FOUND);
		}
		return subsctn;
	}

	/**
	 * This method returns list of subscription
	 */

	@Override
	public List<Subscription> findAllSubscriptions() {

		LOGGER.info("Inside SubscriptionServiceImpl findAllSubscriptions method ");

		return subscriptionDao.findAll();
	}

	/**
	 * This method Adds subscription
	 */
	@Override
	public Subscription saveSubscription(Subscription subscriptionBean) {

		LOGGER.info("Inside SubscriptionServiceImpl saveSubscription method ");
		return subscriptionDao.save(subscriptionBean);
	}

	/**
	 * This method updates subscription for the provided subscription ID
	 */
	@Override
	public Subscription updateSubscription(Subscription subscription) {

		LOGGER.info("Inside SubscriptionServiceImpl updateSubscription method ");
		Subscription existingSubscr = findSubscription(subscription.getId());
		if (Optional.ofNullable(existingSubscr).isPresent()) {
			/** If subscription found save it */
			subscription = this.saveSubscription(subscription);
		} else {
			/** IF Subscription not found throw an exception */
			throw new SubscriptionNotFoundException(Constants.SUBSCRIPTION_NOT_FOUND);
		}
		return subscription;
	}

}
