package com.example.demo.bill.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.commondata.model.AbstractEntity;
import com.example.demo.customer.model.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Bill")
@Getter
@Setter
public class Bill extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "Validated", nullable = false, columnDefinition = "integer null default 0")
	@JsonProperty("Validated")
	private int validated;

	@Column(name = "Status", nullable = true, columnDefinition = "nvarchar(255) not null default 'Nhận đơn'")
	@JsonProperty("Status")
	private String status;

	@Column(name = "TotalPrice", nullable = false, columnDefinition = "bigint not null default 0")
	@JsonProperty("TotalPrice")
	private long totalPrice;

	@Column(name = "Address", nullable = false)
	@JsonProperty("Address")
	private String address;

	@Column(name = "Name", nullable = false)
	@JsonProperty("Name")
	private String name;

	@Column(name = "Phone", nullable = false)
	@JsonProperty("Phone")
	private String phone;

	@Column(name = "Time", nullable = true, columnDefinition = "nvarchar(100) null default '15-20 phút'")
	@JsonProperty("Time")
	private String time;

	@Column(name = "PayBy", nullable = false)
	@JsonProperty("PayBy")
	private String payBy;

	@Column(name = "Note", nullable = true)
	@JsonProperty("Note")
	private String note;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CreatedDate", nullable = false, columnDefinition = "datetime null default now()")
	// @JsonIgnore
	@JsonProperty("CreatedDate")
	private LocalDateTime createdDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = true)
	@JsonProperty("Customer")
	// @JsonIgnore
	// @JsonBackReference
	private Customer customer;

	// Getters & Setters
	public int getValidated() {
		return validated;
	}

	public void setValidated(int validated) {
		this.validated = validated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}
