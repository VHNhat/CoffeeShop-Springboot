package com.example.demo.product.controller;

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

import com.example.demo.product.model.ProductType;
import com.example.demo.product.service.ProductTypeService;

@RestController
public class ProductTypeController {

	@Autowired
	private ProductTypeService service;

	@GetMapping("ProductTypes")
	public ResponseEntity<Object> Get() {
		List<ProductType> types = service.findAll();
		return new ResponseEntity<>(types, HttpStatus.OK);
	}

	@GetMapping("ProductType/{id}")
	public ResponseEntity<Object> Get(@PathVariable("id") long id) {
		Optional<ProductType> type = service.findById(id);
		if (type == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(type, HttpStatus.OK);
	}

	@PostMapping("ProductType/create")
	public ResponseEntity<Object> Post(@RequestBody ProductType model) {
		ProductType type = service.save(model);
		if (type == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(type, HttpStatus.OK);
	}

	@PutMapping("ProductType/update/{id}")
	public ResponseEntity<Object> Put(@RequestBody ProductType model, @PathVariable("id") long id) {
		ProductType type = service.update(model, id);
		if (type == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(type, HttpStatus.OK);
	}

	@DeleteMapping("ProductType/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
