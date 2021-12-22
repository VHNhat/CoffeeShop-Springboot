package com.example.demo.product.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import com.example.demo.commondata.model.AbstractEntity;
//import com.example.demo.shoppingcart.model.ShoppingCart;
import com.example.demo.shoppingcart.model.ShoppingCart_Product;
//import com.example.demo.shoppingcart.model.ListBillDto;
import com.example.demo.supplier.model.Supplier;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(name = "Name", nullable = false)
	@JsonProperty("Name")
	private String name;

	@Column(name = "Description", length = 5000)
	@Size(max = 5000)
	@JsonProperty("Description")
	private String description;

	@Value("0")
	@Column(name = "Price", nullable = false, columnDefinition = "int default 0")
	@JsonProperty("Price")
	private int price;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CreatedDate", nullable = false, columnDefinition = "datetime default now()")
	@JsonProperty("CreatedDate")
	private LocalDateTime createdDate;

	@Column(name = "Photo", length = 5000)
	@JsonProperty("Photo")
	private String photo;

	@Column(name = "Size", nullable = false, columnDefinition = "int default 0")
	@JsonProperty("Size")
	private int size;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductTypeId", nullable = true)
	@JsonProperty("ProductType")
	private ProductType productType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SupplierId", nullable = true)
	@JsonProperty("Supplier")
	private Supplier supplier;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<ShoppingCart_Product> shoppingCart_Products = new HashSet<>();

//	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
//	@JoinTable(name = "shoppingcart_product", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "shoppingcart_id", referencedColumnName = "id", nullable = false, updatable = false))
//	@JsonIgnore
//	private Set<ShoppingCart> shoppingCarts = new HashSet<>();

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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
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

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Set<ShoppingCart_Product> getShoppingCart_Products() {
		return shoppingCart_Products;
	}

	public void setShoppingCart_Products(Set<ShoppingCart_Product> shoppingCart_Products) {
		this.shoppingCart_Products = shoppingCart_Products;
	}

//	public Set<ShoppingCart> getShoppingCarts() {
//		return shoppingCarts;
//	}
//
//	public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
//		this.shoppingCarts = shoppingCarts;
//	}

}
