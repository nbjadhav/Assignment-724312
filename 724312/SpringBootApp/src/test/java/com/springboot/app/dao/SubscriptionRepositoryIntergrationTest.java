package com.springboot.app.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.app.dao.SubscriptionDao;
import com.springboot.app.model.Subscription;
import com.springboot.app.service.impl.SubscriptionServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SubscriptionRepositoryIntergrationTest {

	@InjectMocks
	private SubscriptionServiceImpl subscriptionService;

	@Mock
	private SubscriptionDao subscriptionDao;

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

		Mockito.when(this.subscriptionDao.findById(subscription.getId())).thenReturn(Optional.ofNullable(subscription));

		Subscription subscription = subscriptionService.findSubscription(11);

		assertNotNull(subscription);

	}

	@Test
	public void testSubscriptionNameEquality() {

		Mockito.when(this.subscriptionDao.findById(subscription.getId())).thenReturn(Optional.ofNullable(subscription));

		Subscription subscription = subscriptionService.findSubscription(11);

		assertEquals("Narayan",subscription.getName());

	}

	@Test
	public void testSubscriptionNoyNameEquality() {

		Mockito.when(this.subscriptionDao.findById(subscription.getId())).thenReturn(Optional.ofNullable(subscription));

		Subscription subscription = subscriptionService.findSubscription(11);

		assertNotEquals("TestName",subscription.getName());

	}

	@Test
	public void testGetAllSubscriptions() {

		List<Subscription> subscriptionList = new ArrayList<>();
		subscriptionList.add(subscription);

		Mockito.when(this.subscriptionDao.findAll()).thenReturn(subscriptionList);
		List<Subscription> subscription = subscriptionService.findAllSubscriptions();

		assertNotNull(subscription);

	}

	@Test
	public void testAddSubscription() {

		Mockito.when(this.subscriptionDao.save(subscription)).thenReturn(subscription);

		Subscription subscptn = subscriptionService.saveSubscription(subscription);

		assertNotNull(subscptn);

	}

}
