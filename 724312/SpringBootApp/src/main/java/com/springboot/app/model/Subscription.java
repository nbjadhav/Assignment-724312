package com.springboot.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/*
 * This is a Model class which holds the business data
 */

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

	@Column(name = "id")
	@Id
	@NotNull(message = "ID is mandatory")
	private int id;

	@NotNull(message = "Name is mandatory")
	@Column(name = "name")
	private String name;

	@DecimalMin("1.00")
	@Column(name = "monthlyPrice")
	private BigDecimal monthlyPrice;

	@Column(name = "lastUpdate")
	private LocalDate lastUpdate;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the monthlyPrice
	 */
	public BigDecimal getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * @param monthlyPrice the monthlyPrice to set
	 */
	public void setMonthlyPrice(BigDecimal monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * @return the lastUpdate
	 */
	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
