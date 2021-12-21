package com.example.demo.customer.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.customer.model.Customer;
import com.example.demo.customer.model.SigninDto;
import com.example.demo.customer.model.SignupDto;
import com.example.demo.customer.model.UpdateCustomer;
import com.example.demo.customer.repository.CustomerRepository;
import com.example.demo.security.jwt.LoginResponse;
import com.google.gson.Gson;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public Optional<LoginResponse> Login(SigninDto dto) {
		try {
			Optional<LoginResponse> cus = repo.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
			return cus;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public String Register(SignupDto dto) {

		List<String> errorList = new LinkedList<String>();
		boolean[] flag = { false, false, false };
		List<Customer> customers = repo.findAll();
		for (Customer customer : customers) {
			if (customer.getUsername().equals(dto.getUsername())) {
				if (!flag[0]) {
					flag[0] = true;
					errorList.add("Username");
				}
			}
			if (customer.getEmail().equals(dto.getEmail())) {
				if (!flag[1]) {
					flag[1] = true;
					errorList.add("Email");
				}
			}
			if (customer.getPhone().equals(dto.getPhone())) {
				if (!flag[2]) {
					flag[2] = true;
					errorList.add("Phone");
				}
			}
		}
		if (!errorList.isEmpty()) {
			return new Gson().toJson(errorList);
		}
		try {
			Customer customer = new Customer();
			customer.setUsername(dto.getUsername());
			customer.setPassword(dto.getPassword());
			customer.setPhone(dto.getPhone());
			customer.setEmail(dto.getEmail());
			customer.setName(dto.getName());
			repo.save(customer);
			return "1";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "0";
		}

	}

	@Override
	public Customer update(UpdateCustomer dto, long id) {
		try {
			Customer cus = repo.getById(id);
			cus.setName(dto.getName());
			cus.setEmail(dto.getEmail());
			cus.setPhone(dto.getPhone());
			cus.setAddress(dto.getAddress());
			cus.setGender(dto.getGender());
			cus.setAvata(dto.getAvatar());

			return repo.save(cus);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}
}
