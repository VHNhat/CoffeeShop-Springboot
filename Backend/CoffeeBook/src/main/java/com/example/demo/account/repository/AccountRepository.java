package com.example.demo.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.account.model.Account;
import com.example.demo.account.model.AdminLoginResponse;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByUsernameAndPassword(String username, String password);

}
