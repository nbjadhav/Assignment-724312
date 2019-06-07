package com.springboot.app.controller;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.app.controller.SubscriptionController;
import com.springboot.app.model.Subscription;
import com.springboot.app.service.impl.SubscriptionServiceImpl;

import reactor.core.publisher.Flux;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SubscriptionControllerTest {

	@InjectMocks
	private SubscriptionController subscriptionController;

	@Mock
	private SubscriptionServiceImpl subscriptionService;

	private Subscription subscription;

	@Before
	public void setUp() {
		subscription = new Subscription();
		subscription.setId(11);
		subscription.setMonthlyPrice(new BigDecimal(22.566));
		subscription.setName("Narayan");

	}

	@Test
	public void testFindSubscriptionById() {

		Mockito.when(this.subscriptionService.findSubscription(subscription.getId())).thenReturn(subscription);

		Flux<ResponseEntity<Subscription>> subscription = subscriptionController.getSubscription(11);

		assertNotNull(subscription);

	}

	@Test
	public void testGetAllSubscriptions() {

		List<Subscription> subscriptionList = new ArrayList<>();
		subscriptionList.add(subscription);

		Mockito.when(this.subscriptionService.findAllSubscriptions()).thenReturn(subscriptionList);

		Flux<ResponseEntity<List<Subscription>>> subscription = subscriptionController.getAllSubscriptions();

		assertNotNull(subscription);

	}

	@Test
	public void testAddSubscription() {

		Mockito.when(this.subscriptionService.saveSubscription(subscription)).thenReturn(subscription);

		Flux<ResponseEntity> subscptn = subscriptionController.addSubscription(subscription);

		assertNotNull(subscription);

	}

	@Test
	public void testUpdateSubscription() {

		Mockito.when(this.subscriptionService.updateSubscription(subscription)).thenReturn(subscription);

		Flux<ResponseEntity> subscptn = subscriptionController.updateSubscription(subscription, 1);

		assertNotNull(subscription);

	}
}
