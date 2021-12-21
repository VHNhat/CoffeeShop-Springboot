//package com.example.demo.security.service;
//
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.customer.model.Customer;
//import com.example.demo.customer.model.SigninDto;
//import com.example.demo.customer.repository.CustomerRepository;
//import com.example.demo.security.model.CustomerUserDetails;
//
//@Service
//public class CustomerDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private CustomerRepository customerRepo;
//
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Customer customer = customerRepo.findByUsername(username);
//		
//		if (customer == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		System.out.println(customer.getUsername() + " " + customer.getPassword());
//		return new CustomerUserDetails(customer);
//	}
//	
//	// JWTAuthenticationFilter sẽ sử dụng hàm này
//    @Transactional
//    public UserDetails loadUserById(Long id) {
//    	Customer customer = customerRepo.findById(id).orElseThrow(
//                () -> new UsernameNotFoundException("User not found with id : " + id)
//        );
//
//        return new CustomerUserDetails(customer);
//    }
//	
//	public Customer save(SigninDto signinDto) {
//		Customer newUser = new Customer();
//		newUser.setUsername(signinDto.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(signinDto.getPassword()));
//		return customerRepo.save(newUser);
//	}
//}
