package com.example.demo.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.shoppingcart.model.ShoppingCart;
import com.example.demo.shoppingcart.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService service;
	
	@GetMapping("carts")
	public ResponseEntity<Object> Get(){
		List<ShoppingCart> carts = service.findAll();
		return new ResponseEntity<>(carts,HttpStatus.OK);
	}
}
