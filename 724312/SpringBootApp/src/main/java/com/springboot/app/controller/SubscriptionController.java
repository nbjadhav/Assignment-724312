package com.springboot.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Subscription;
import com.springboot.app.service.SubscriptionService;
import com.springboot.app.util.Constants;

import reactor.core.publisher.Flux;

/**
 * This is a rest controller class. An Entry point for an api which holds all
 * the subscription API end point
 *
 */
@RestController
@Validated
@RequestMapping(Constants.API)
public class SubscriptionController {

	private static final Logger LOGGER = LogManager.getLogger(SubscriptionController.class);

	@Autowired
	private SubscriptionService subscriptionService;

	

	/**
	 * This method used to get subscription list for the user
	 * 
	 * @return subscription list
	 */
	@GetMapping(Constants.SUBSCRIPTIONS)
	public Flux<ResponseEntity<List<Subscription>>> getAllSubscriptions() {

		LOGGER.info("Inside SubscriptionController getAllSubscriptions method");
		return Flux.just(new ResponseEntity<List<Subscription>>(subscriptionService.findAllSubscriptions(),HttpStatus.OK));

	}

	/**
	 * This method used to get single subscription based on passed as uri parameter
	 * 
	 * @param id
	 * @return Subscription
	 */
	@GetMapping(Constants.SUBSCRIPTIONS_ID)
	public Flux<ResponseEntity<Subscription>> getSubscription(@PathVariable Integer id) {

		LOGGER.info("Inside SubscriptionController getSubscription method");
		return Flux.just(new ResponseEntity<Subscription>(subscriptionService.findSubscription(id),HttpStatus.OK));
	}

	/**
	 * This method used to add the subscription passed as request body
	 * 
	 * @param subscription
	 * @return Response entity response message
	 */
	@PostMapping(Constants.SUBSCRIPTIONS)
	public Flux<ResponseEntity> addSubscription(@Valid @RequestBody Subscription subscription) {

		LOGGER.info("Inside SubscriptionController addSubscription method");
		return Flux.just(
				new ResponseEntity<Subscription>(subscriptionService.saveSubscription(subscription),HttpStatus.OK));
	}
	
	/**
	 * This method used to update the subscription passed as request body
	 * 
	 * @param subscription
	 * @param Id
	 * @return Response entity response message
	 */
	@PutMapping(Constants.SUBSCRIPTIONS_ID)
	public Flux<ResponseEntity> updateSubscription(@Valid @RequestBody Subscription subscription,
			@PathVariable Integer id) {

		LOGGER.info("Inside SubscriptionController updateSubscription method");
		subscription.setId(id);
		return Flux.just(new ResponseEntity<Subscription>(subscriptionService.updateSubscription(subscription),HttpStatus.OK));
	}


}
