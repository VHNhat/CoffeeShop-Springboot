package com.example.demo.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreDistrict {

	@JsonProperty("Count")
	private Long count;
	
	@JsonProperty("District")
	private String district;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public StoreDistrict(String district, Long count) {
		this.count = count;
		this.district = district;
	}

	public StoreDistrict() {
	}
	
	
}
