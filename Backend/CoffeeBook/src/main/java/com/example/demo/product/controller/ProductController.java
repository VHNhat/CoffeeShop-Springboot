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

import com.example.demo.product.model.AddProductDto;
import com.example.demo.product.model.Product;
import com.example.demo.product.model.UpdateProductDto;
import com.example.demo.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("products")
	public ResponseEntity<Object> Get() {
		List<Product> products = service.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("product/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<Product> products = service.findById(id);
		if (products == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping("product/create")
	public ResponseEntity<Object> Post(@RequestBody AddProductDto dto) {
		Product newPro = service.save(dto);
		if (newPro == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newPro, HttpStatus.OK);
	}

	@PutMapping("product/update/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") long id, @RequestBody UpdateProductDto dto) {
		Product pro = service.update(dto, id);
		if (pro == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

	@DeleteMapping("product/delete/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
