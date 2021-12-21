package com.example.demo.account.service;


import javax.validation.Valid;

import com.example.demo.account.model.Account;
import com.example.demo.account.model.AddAccountDto;
import com.example.demo.account.model.AdminLoginDto;
import com.example.demo.account.model.AdminLoginResponse;
import com.example.demo.account.model.UpdateAccountDto;
import com.example.demo.commondata.GenericService;

public interface AccountService extends GenericService<Account, Long> {

	//Account findByUsernameAndPassword(String username, String password);
	
	Account update(UpdateAccountDto dto, long id);

	Account save(@Valid AddAccountDto dto);

	AdminLoginResponse Login(AdminLoginDto dto);
}
