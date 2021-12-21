package com.example.demo.product.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.commondata.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ProductType")
@Getter
@Setter
public class ProductType extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(unique = true, name = "Name", nullable = false)
	@JsonProperty("Name")
	private String name;

	@Column(name = "Description")
	@JsonProperty("Description")
	private String description;

	@Column(name = "Photo")
	@JsonProperty("Photo")
	private String photo;

	@OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Product> products = new HashSet<>();

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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
