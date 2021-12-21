package com.example.demo.store.controller;

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

import com.example.demo.store.model.AddStoreDto;
import com.example.demo.store.model.Store;
import com.example.demo.store.model.StoreDistrict;
import com.example.demo.store.model.UpdateStoreDto;
import com.example.demo.store.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService service;

	@GetMapping("stores")
	public ResponseEntity<Object> Get() {
		List<Store> stores = service.findAll();
		return new ResponseEntity<>(stores, HttpStatus.OK);
	}

	@GetMapping("store/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<Store> store = service.findById(id);
		if (store == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(store, HttpStatus.OK);
	}
	
	@GetMapping("stores/district")
	public ResponseEntity<Object> GetById() {
		List<StoreDistrict> stores = service.findByDistrict();
		return new ResponseEntity<>(stores, HttpStatus.OK);
	}

	@PostMapping("store/create")
	public ResponseEntity<Object> Post(@RequestBody AddStoreDto dto) {
		Store store = service.save(dto);
		if (store == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(store, HttpStatus.OK);
	}

	@PutMapping("store/update/{id}")
	public ResponseEntity<Object> Put(@RequestBody UpdateStoreDto dto, @PathVariable("id") long id) {
		Store store = service.update(dto, id);
		if (store == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(store, HttpStatus.OK);
	}

	@DeleteMapping("store/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
