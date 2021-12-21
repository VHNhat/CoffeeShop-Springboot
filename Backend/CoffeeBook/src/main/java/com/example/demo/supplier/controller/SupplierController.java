package com.example.demo.supplier.controller;

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

import com.example.demo.supplier.model.Supplier;
import com.example.demo.supplier.service.SupplierService;

@RestController
public class SupplierController {

	@Autowired
	private SupplierService service;
	
	@GetMapping("supplier")
	public ResponseEntity<Object> Get() {
		List<Supplier> supps = service.findAll();
		return new ResponseEntity<>(supps, HttpStatus.OK);
	}

	@GetMapping("supplier/{id}")
	public ResponseEntity<Object> Get(@PathVariable("id") long id) {
		Optional<Supplier> supp = service.findById(id);
		if (supp == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(supp, HttpStatus.OK);
	}

	@PostMapping("supplier/add")
	public ResponseEntity<Object> Post(@RequestBody Supplier model) {
		Supplier supp = service.save(model);
		if (supp == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(supp, HttpStatus.OK);
	}

	@PutMapping("supplier/edit/{id}")
	public ResponseEntity<Object> Put(@RequestBody Supplier model, @PathVariable("id") long id) {
		Supplier supp = service.update(model, id);
		if (supp == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(supp, HttpStatus.OK);
	}

	@DeleteMapping("supplier/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
