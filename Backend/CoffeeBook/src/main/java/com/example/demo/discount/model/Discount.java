package com.example.demo.discount.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.commondata.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Discount")
@Getter
@Setter
public class Discount extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(name = "Name", nullable = false)
	@JsonProperty("Name")
	private String name;

	@Column(name = "Value", nullable = false, columnDefinition = "integer default 0")
	@JsonProperty("Value")
	private int value;

	@Column(name = "Quantity", nullable = false, columnDefinition = "integer default 0")
	@JsonProperty("Quantity")
	private int quantity;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "ExpiredDate", nullable = false, columnDefinition = "datetime default now()")
	@JsonProperty("ExpiredDate")
	private LocalDateTime expiredDate;

	@Column(name = "Photo")
	@JsonProperty("Photo")
	private String photo;
	
	@Column(name = "MinPrice")
	@JsonProperty("MinPrice")
	private int minPrice;

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDateTime expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

}
