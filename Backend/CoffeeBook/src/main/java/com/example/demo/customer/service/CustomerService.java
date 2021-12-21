package com.example.demo.customer.service;


import java.util.Optional;

import com.example.demo.commondata.GenericService;
import com.example.demo.customer.model.Customer;
import com.example.demo.customer.model.SigninDto;
import com.example.demo.customer.model.SignupDto;
import com.example.demo.customer.model.UpdateCustomer;
import com.example.demo.security.jwt.LoginResponse;

public interface CustomerService extends GenericService<Customer, Long> {

	Optional<LoginResponse> Login(SigninDto dto);

	String Register(SignupDto dto);

	Customer update(UpdateCustomer dto, long id);

}
