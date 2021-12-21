package com.example.demo.shoppingcart.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.commondata.model.AbstractEntity;
import com.example.demo.customer.model.Customer;
//import com.example.demo.product.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ShoppingCart")
@Getter
@Setter
public class ShoppingCart extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = true)
	@JsonProperty("Customer")
	private Customer customer;

	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<ShoppingCart_Product> shoppingCart_Products = new HashSet<>();

	@Column(name = "ProductQuantity", nullable = false, columnDefinition = "int default 0")
	@JsonProperty("ProductQuantity")
	private int productQuantity;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CreatedDate", nullable = false, columnDefinition = "datetime null default now()")
	@JsonProperty("CreatedDate")
	private LocalDateTime createdDate;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shoppingCarts")
//	private Set<Product> products = new HashSet<>();

	// Getters & Setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Set<ShoppingCart_Product> getShoppingCart_Products() {
		return shoppingCart_Products;
	}

	public void setShoppingCart_Products(Set<ShoppingCart_Product> shoppingCart_Products) {
		this.shoppingCart_Products = shoppingCart_Products;
	}

}
