package com.example.demo.staff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.example.demo.commondata.model.AbstractEntity;
import com.example.demo.store.model.Store;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Employee")
@Getter
@Setter
public class Employee extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Size(max = 100)
	@Column(nullable = false, name = "Name")
	@JsonProperty("Name")
	private String name;

	@Column(nullable = false, name = "Age")
	@JsonProperty("Age")
	private int age;

	@Column(name = "Gender")
	@JsonProperty("Gender")
	private int gender;

	@Column(nullable = false, name = "Email", unique = true)
	@JsonProperty("Email")
	private String email;

	@Column(nullable = false, name = "Phone", unique = true)
	@JsonProperty("Phone")
	private String phone;

	@Column(nullable = false, name = "Address")
	@JsonProperty("Address")
	private String address;

	@Column(nullable = false, name = "City")
	@JsonProperty("City")
	private String city;

	@Column(nullable = false, name = "Country")
	@JsonProperty("Country")
	private String country;

	@Column(name = "Salary", nullable = false, columnDefinition = "bigint default 0")
	@JsonProperty("Salary")
	private long salary;

	@Column(name = "Status", columnDefinition = "nvarchar(255) default 'Hoạt động'")
	@JsonProperty("Status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = true)
	@JsonProperty("Store")
	private Store store;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
