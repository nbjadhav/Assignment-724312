package com.springboot.app;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.springboot.app.model.Subscription;
import com.springboot.app.service.SubscriptionService;

/**
 * 
 * This class is the main class and starting point of the application. 
 *
 */
@SpringBootApplication
public class Application {

	@Autowired
	private SubscriptionService service;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	
	@EventListener(ApplicationReadyEvent.class)
    public void  loadSubscriptionData() {
        
        Subscription subscriber =new Subscription();
        subscriber.setId(1001);
        subscriber.setName("User 1");
        subscriber.setMonthlyPrice(BigDecimal.valueOf(300));
        subscriber.setLastUpdate(LocalDate.now());
        service.saveSubscription(subscriber);
        
    }    

}
