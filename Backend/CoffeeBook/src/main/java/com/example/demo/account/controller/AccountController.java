package com.example.demo.account.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.account.model.Account;
import com.example.demo.account.model.AddAccountDto;
import com.example.demo.account.model.AdminLoginDto;
import com.example.demo.account.model.AdminLoginResponse;
import com.example.demo.account.model.UpdateAccountDto;
import com.example.demo.account.service.AccountService;
import com.example.demo.security.jwt.JwtTokenProvider;
import com.example.demo.security.jwt.TokenResponse;
import com.google.gson.Gson;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;
	@Autowired
	private JwtTokenProvider jwtTokenUtil;

	@GetMapping("account")
	public ResponseEntity<Object> Get() {
		List<Account> accounts = service.findAll();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@GetMapping("account/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<Account> account = service.findById(id);
		if (account == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@PostMapping("account/add")
	public ResponseEntity<Object> Post(@RequestBody AddAccountDto dto) {
		Account newAccount = service.save(dto);
		if(newAccount == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newAccount, HttpStatus.OK);
	}

	@PostMapping("admin/login")
	public ResponseEntity<Object> Login(@RequestBody AdminLoginDto dto) {
//		Account account = service.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
//		if (account == null)
//			return new ResponseEntity<>("Username or Password is invalid", HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<>(account, HttpStatus.OK);
		
		
		//
		AdminLoginResponse acc = service.Login(dto);
		if(acc == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		String json = new Gson().toJson(acc);
		String token = jwtTokenUtil.generateTokenAdmin(json,String.valueOf(acc.getId()),acc.getUsername(),acc.getRoleId());
		TokenResponse res = new TokenResponse();
		res.setToken(token);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PutMapping("account/edit/{id}")
	public ResponseEntity<Object> Put(@RequestBody UpdateAccountDto dto, @PathVariable("id") long id) {
		Account updatedRole = service.update(dto, id);
		if (updatedRole == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedRole, HttpStatus.OK);
	}

	@DeleteMapping("account/delete/{id}")
	public ResponseEntity<Object> DeleteeAccount(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
