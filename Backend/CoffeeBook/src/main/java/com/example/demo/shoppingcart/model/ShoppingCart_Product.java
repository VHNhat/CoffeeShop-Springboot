package com.example.demo.shoppingcart.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.demo.product.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ShoppingCart_Product")
public class ShoppingCart_Product {

	@EmbeddedId
	CheckoutKey id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("shoppingcartId")
	@JoinColumn(name = "shoppingCartId", nullable = false)
	@JsonProperty("ShoppingCart")
	private ShoppingCart shoppingCart;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	@JoinColumn(name = "productId", nullable = false)
	@JsonProperty("Product")
	private Product product;

	@Column(name = "TitleSize", columnDefinition = "nvarchar(100) Null default 'Nhỏ' ")
	@JsonProperty("TitleSize")
	private String titleSize;

	
	@Column(name = "Count", columnDefinition = "int not null default 0")
	@JsonProperty("Count")
	private int count;

	@Column(name = "CreatedDate", columnDefinition = "datetime null default now()")
	@JsonProperty("CreatedDate")
	private LocalDateTime createdDate;
	
	

	public ShoppingCart_Product() {
		super();
	}

	// ctor
	public ShoppingCart_Product(CheckoutKey id) {
		this.id = id;
	}

	// Getters & Setters
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getTitleSize() {
		return titleSize;
	}

	public void setTitleSize(String titleSize) {
		this.titleSize = titleSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public CheckoutKey getId() {
		return id;
	}

	public void setId(CheckoutKey id) {
		this.id = id;
	}

}
