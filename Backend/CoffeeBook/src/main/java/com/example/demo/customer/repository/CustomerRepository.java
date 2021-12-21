package com.example.demo.customer.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.customer.model.Customer;
import com.example.demo.security.jwt.LoginResponse;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT new com.example.demo.security.jwt.LoginResponse(u.id, u.username, u.email) FROM Customer u WHERE u.username = ?1 AND u.password = ?2")
	Optional<LoginResponse> findByUsernameAndPassword(String username, String password);
	Customer findByUsername(String username);
	//Long findIdByUsernameAndPassword(String username,String password);

}
