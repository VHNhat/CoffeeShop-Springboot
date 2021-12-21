package com.example.demo.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateStoreDto {

	@JsonProperty("StoreName")
	private String storeName;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Phone")
	private String phone;

	@JsonProperty("ManagerId")
	private long managerId;

	// Getters & Setters
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long storeId) {
		this.managerId = storeId;
	}

}
