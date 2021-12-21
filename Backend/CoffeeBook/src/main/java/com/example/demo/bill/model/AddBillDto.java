package com.example.demo.bill.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddBillDto {

	@JsonProperty("Address")
	private String address;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Phone")
	private String phone;
	@JsonProperty("Time")
	private String time;
	@JsonProperty("PayBy")
	private String payBy;
	@JsonProperty("Note")
	private String note;
	@JsonProperty("TotalPrice")
	private int totalPrice;
	@JsonProperty("CustomerId")
	private long customerId;

	// Getters & Setters
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPayBy() {
		return payBy;
	}

	public void setPayBy(String payBy) {
		this.payBy = payBy;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}
