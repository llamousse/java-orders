package com.vyue.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order
{
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ordnum;

	private double ordamount;
	private double advanceamount;
	private String orddescription;

	// one to many
	// one customer to many orders
	@ManyToOne
	@JoinColumn(name = "custcode", nullable = false)
	@JsonIgnoreProperties("orders")
	private Customer customer;

	// constructors
	public Order(double ordamount, double advanceamount, String orddescription, Customer customer)
	{
		this.ordamount = ordamount;
		this.advanceamount = advanceamount;
		this.orddescription = orddescription;
		this.customer = customer;
	}

	// default constructor
	public Order()
	{
	}

	// getters and setters
	public long getOrdnum()
	{
		return ordnum;
	}

	public void setOrdnum(long ordnum)
	{
		this.ordnum = ordnum;
	}

	public double getOrdamount()
	{
		return ordamount;
	}

	public void setOrdamount(double ordamount)
	{
		this.ordamount = ordamount;
	}

	public double getAdvanceamount()
	{
		return advanceamount;
	}

	public void setAdvanceamount(double advanceamount)
	{
		this.advanceamount = advanceamount;
	}

	public String getOrddescription()
	{
		return orddescription;
	}

	public void setOrddescription(String orddescription)
	{
		this.orddescription = orddescription;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
}
