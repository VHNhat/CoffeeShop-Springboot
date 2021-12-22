package com.example.demo.customer.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.model.Customer;
import com.example.demo.customer.model.SigninDto;
import com.example.demo.customer.model.SignupDto;
import com.example.demo.customer.model.UpdateCustomer;
import com.example.demo.customer.service.CustomerService;
import com.example.demo.security.jwt.LoginResponse;
import com.example.demo.security.jwt.TokenResponse;
//import com.example.demo.security.jwt.Jwt;
import com.example.demo.security.jwt.JwtTokenProvider;
//import com.example.demo.security.model.CustomerUserDetails;
import com.google.gson.Gson;
//import com.example.demo.security.service.CustomerDetailsServiceImpl;

@RestController
public class CustomerController {

//	@Autowired
//	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomerService service;
	@Autowired
	private JwtTokenProvider jwtTokenUtil;
//	@Autowired
//	private CustomerDetailsServiceImpl userDetailsService;

	@GetMapping("customer")
	public ResponseEntity<Object> Get() {
		List<Customer> customers = service.findAll();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("customer/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<Customer> customer = service.findById(id);
		if (customer == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping("customer/add")
	public ResponseEntity<Object> Post(@RequestBody Customer customer) {
		Customer newCustomer = service.save(customer);
		if (newCustomer == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newCustomer, HttpStatus.OK);
	}

	@PostMapping("customer/login")
	public ResponseEntity<Object> Login(@Valid @RequestBody SigninDto dto) throws Exception {
//		System.out.println("Username: " + dto.getUsername());
//		System.out.println("Password: " + dto.getPassword());
//		// Xác thực thông tin người dùng Request lên
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                		dto.getUsername(),
//                		dto.getPassword()
//                )
//        );
//
//        // Nếu không xảy ra exception tức là thông tin hợp lệ
//        // Set thông tin authentication vào Security Context
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Trả về jwt cho người dùng.
//        String jwt = tokenProvider.generateToken((CustomerUserDetails) authentication.getPrincipal());
//        return new ResponseEntity<>((Object) new LoginResponse(jwt),HttpStatus.OK);
		Optional<LoginResponse> cus = service.Login(dto);
		if(cus == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		String json = new Gson().toJson(cus);
		String token = jwtTokenUtil.generateToken(json,String.valueOf(cus.get().getId()),cus.get().getUsername(),cus.get().getEmail());
		TokenResponse res = new TokenResponse();
		res.setToken(token);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("customer/signup")
	public ResponseEntity<Object> Register(@RequestBody SignupDto dto) {
		String res = service.Register(dto);
		if (res == "1")
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(new Gson().toJson(res), HttpStatus.OK);
	}

	@PutMapping("customer/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") long id, @RequestBody UpdateCustomer dto) {
		Customer customer = service.update(dto, id);
		if (customer == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@DeleteMapping("customer/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
//	private void authenticate(String username, String password) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
}
