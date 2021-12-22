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
	
	@JsonProperty("LinkGG")
	private String linkGG;
	
	@JsonProperty("District")
	private String district;
	
	@JsonProperty("Photo")
	private String photo;

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

	public String getLinkGG() {
		return linkGG;
	}

	public void setLinkGG(String linkGG) {
		this.linkGG = linkGG;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
