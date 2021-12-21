package com.example.demo.discount.controller;

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

import com.example.demo.discount.model.Discount;
import com.example.demo.discount.service.DiscountService;

@RestController
public class DiscountController {

	@Autowired
	private DiscountService service;

	@GetMapping("discount")
	public ResponseEntity<Object> Get() {
		List<Discount> discounts = service.findAllWithQuantity();
		return new ResponseEntity<>(discounts, HttpStatus.OK);
	}

	@GetMapping("discount/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<Discount> discounts = service.findById(id);
		if (discounts == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(discounts, HttpStatus.OK);
	}

	@PostMapping("discount/add")
	public ResponseEntity<Object> AddDiscount(@RequestBody Discount discount) {
		Discount newDiscount = service.save(discount);
		if (newDiscount == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newDiscount, HttpStatus.OK);
	}

	@PutMapping("discount/edit/{id}")
	public ResponseEntity<Object> UpdateDiscount(@RequestBody Discount discount, @PathVariable("id") long id) {
		Discount updateDiscount = service.update(discount,id);
		if (updateDiscount == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updateDiscount, HttpStatus.OK);
	}

	@DeleteMapping("discount/delete/{id}")
	public ResponseEntity<Object> DeleteById(@PathVariable("id") Long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
