package com.example.demo.bill.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaleYear {

	@JsonProperty("Month")
	private int month;
	
	@JsonProperty("Sales")
	private Long sales;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Long getSales() {
		return sales;
	}

	public void setSales(Long sales) {
		this.sales = sales;
	}

	public SaleYear(int month, Long sales) {
		this.month = month;
		this.sales = sales;
	}

	public SaleYear() {
	}
	
	
}
