//package com.example.demo.security.model;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.demo.customer.model.Customer;
//
//public class CustomerUserDetails implements UserDetails {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	Customer customer;
//	
//	public CustomerUserDetails(Customer cus) {
//		customer = cus;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
//	}
//
//	@Override
//	public String getPassword() {
//		return customer.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return customer.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//}
