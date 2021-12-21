package com.example.demo.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateProductDto {

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Price")
	private int price;
	@JsonProperty("Photo")
	private String photo;
	@JsonProperty("Size")
	private int size;
	@JsonProperty("ProductTypeId")
	private long productTypeId;
	@JsonProperty("SupplierId")
	private long supplierId;

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

}
