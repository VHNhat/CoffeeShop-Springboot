package com.example.demo.discount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.discount.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

	@Query("SELECT d FROM Discount d WHERE d.quantity > 0 and d.expiredDate > NOW()")
	List<Discount> findWithQuantity();
}
