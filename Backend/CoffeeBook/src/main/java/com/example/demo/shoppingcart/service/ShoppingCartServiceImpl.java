package com.example.demo.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.shoppingcart.model.ShoppingCart;
import com.example.demo.shoppingcart.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl extends GenericServiceImpl<ShoppingCart, Long> implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository repo;
}
