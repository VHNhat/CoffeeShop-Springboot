package com.example.demo.supplier.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.example.demo.commondata.model.AbstractEntity;
import com.example.demo.product.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Supplier")
@Getter
@Setter
public class Supplier extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "Name")
	@JsonProperty("Name")
	private String name;

	@Column(name = "Description")
	@JsonProperty("Description")
	private String description;

	@Column(name = "Address")
	@JsonProperty("Address")
	private String address;

	@Column(name = "City")
	@JsonProperty("City")
	private String city;

	@Column(name = "Country")
	@JsonProperty("Country")
	private String country;

	@Column(unique = true, name = "Phone")
	@Size(min = 10, max = 11)
	@JsonProperty("Phone")
	private String phone;

	@Column(name = "Url")
	@JsonProperty("Url")
	private String url;

	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Product> products;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
