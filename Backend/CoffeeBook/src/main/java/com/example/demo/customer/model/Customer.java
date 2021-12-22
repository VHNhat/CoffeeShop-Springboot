package com.example.demo.customer.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.example.demo.bill.model.Bill;
import com.example.demo.commondata.model.AbstractEntity;
import com.example.demo.shoppingcart.model.ShoppingCart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class Customer extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(unique = true, name = "Username", nullable = false)
	@Size(min = 3, max = 100)
	@JsonProperty("Username")
	private String username;

	@Column(name = "Password", nullable = false)
	@Size(min = 3, max = 100)
	@JsonProperty("Password")
	private String password;

	@Email
	@Size(max = 100)
	@Column(unique = true, name = "Email", nullable = false)
	@JsonProperty("Email")
	private String email;

	@Column(unique = true, name = "Phone", nullable = false)
	@Size(max = 11)
	@JsonProperty("Phone")
	private String phone;

	@Column(name = "Name", nullable = false)
	@JsonProperty("Name")
	private String name;

	@JsonProperty("Avata")
	@Size(max = 5000)
	@Column(name = "Avata", length = 5000)
	private String avata;
	@Column(name = "Address")
	@JsonProperty("Address")
	private String address;
	@Column(name = "City")
	@JsonProperty("City")
	private String city;
	@Column(name = "Country")
	@JsonProperty("Country")
	private String country;
	@Column(name = "Gender")
	@JsonProperty("Gender")
	private int gender;

	@OneToMany(mappedBy = "customer")
	// @JsonIgnoreProperties("customer")
	@JsonIgnore
	// @JsonManagedReference
	private Set<Bill> bills = new HashSet<>();
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	// @JsonIgnoreProperties("customer")
	@JsonIgnore
	private Set<ShoppingCart> shoppingCarts = new HashSet<>();

	
	@PreRemove
	private void preRemove() {
	    for (Bill b : bills) {
	        b.setCustomer(null);
	    }
	}
	
	// Getters & Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvata() {
		return avata;
	}

	public void setAvata(String avata) {
		this.avata = avata;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	public Set<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

}
