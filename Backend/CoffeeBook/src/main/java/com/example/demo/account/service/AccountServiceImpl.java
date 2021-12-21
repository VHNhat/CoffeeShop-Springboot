package com.example.demo.account.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.account.model.Account;
import com.example.demo.account.model.AddAccountDto;
import com.example.demo.account.model.AdminLoginDto;
import com.example.demo.account.model.AdminLoginResponse;
import com.example.demo.account.model.UpdateAccountDto;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.role.model.Role;
import com.example.demo.role.repository.RoleRepository;

@Service
public class AccountServiceImpl extends GenericServiceImpl<Account, Long> implements AccountService {

	@Autowired
	private AccountRepository repo;
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public Account update(UpdateAccountDto dto, long id) {
		try {
			Role role = roleRepo.findById(dto.getRoleId()).get();
			Account acc = repo.getById(id);
			acc.setUsername(dto.getUsername());
			acc.setPassword(dto.getPassword());
			acc.setName(dto.getName());
			acc.setAvatar(acc.getAvatar());
			acc.setRole(role);
			return repo.save(acc);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public Account save(@Valid AddAccountDto dto) {
		try {
			Role role = roleRepo.findById(dto.getRoleId()).get();
			Account account = new Account();
			account.setUsername(dto.getUsername());
			account.setPassword(dto.getPassword());
			account.setName(dto.getName());
			account.setAvatar(dto.getAvatar());
			account.setRole(role);
			return repo.save(account);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public AdminLoginResponse Login(AdminLoginDto dto) {
		try {
			Optional<Account> account = repo.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
			AdminLoginResponse acc = new AdminLoginResponse();
			acc.setId(account.get().getId());
			acc.setUsername(account.get().getUsername());
			acc.setRoleId(account.get().getRole().getId());
			return acc;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
