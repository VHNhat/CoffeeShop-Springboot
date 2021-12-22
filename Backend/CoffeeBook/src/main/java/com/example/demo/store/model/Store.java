package com.example.demo.store.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import com.example.demo.commondata.model.AbstractEntity;
import com.example.demo.staff.model.Employee;
import com.example.demo.staff.model.Manager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Store")
@Getter
@Setter
public class Store extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "StoreName", nullable = false)
	@JsonProperty("StoreName")
	private String storeName;

	@Column(name = "Description")
	@JsonProperty("Description")
	private String description;

	@Column(name = "Address", unique = true, nullable = false)
	@JsonProperty("Address")
	private String address;

	@Column(name = "Country", nullable = false)
	@JsonProperty("Country")
	private String country;

	@Column(name = "Phone", nullable = false)
	@JsonProperty("Phone")
	private String phone;
	
	@Column(name = "Photo", nullable = true, length = 5000)
	@JsonProperty("Photo")
	private String photo;
	
	@Column(name = "LinkGG", nullable = true)
	@JsonProperty("LinkGG")
	private String linkGG;
	
	@Column(name = "District", nullable = true)
	@JsonProperty("District")
	private String district;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", nullable = true)
	@JsonProperty("Manager")
	private Manager manager;

	@OneToMany(mappedBy = "store")
	@JsonIgnore
	private Set<Employee> employee = new HashSet<>();

	@PreRemove
	private void preRemove() {
	    for (Employee e : employee) {
	        e.setStore(null);
	    }
	}
	
	// Getters & Setters
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLinkGG() {
		return linkGG;
	}

	public void setLinkGG(String linkGG) {
		this.linkGG = linkGG;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
