package com.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.model.Subscription;

/**
 * This is the Data access layer which interacts with the data layer of the
 * Application
 * 
 */
@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, Integer>{

}
