package com.example.demo.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.shoppingcart.model.ShoppingCart_Product;

@Repository
public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCart_Product, Object> {

}
