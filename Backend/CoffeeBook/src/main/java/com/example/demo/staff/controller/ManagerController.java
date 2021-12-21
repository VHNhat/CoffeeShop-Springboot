package com.example.demo.staff.controller;

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

import com.example.demo.staff.model.AddManagerDto;
import com.example.demo.staff.model.Manager;
import com.example.demo.staff.model.UpdateManagerDto;
import com.example.demo.staff.service.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService service;

	@GetMapping("managers")
	public ResponseEntity<Object> Get() {
		List<Manager> managers = service.findAll();
		return new ResponseEntity<>(managers, HttpStatus.OK);
	}

	@GetMapping("manager/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<Manager> manager = service.findById(id);
		if (manager == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(manager, HttpStatus.OK);
	}

	@PostMapping("manager/create")
	public ResponseEntity<Object> Post(@RequestBody AddManagerDto dto) {
		Manager manager = service.save(dto);
		if (manager == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(manager, HttpStatus.OK);
	}

	@PutMapping("manager/update/{id}")
	public ResponseEntity<Object> Put(@RequestBody UpdateManagerDto dto, @PathVariable("id") long id) {
		Manager manager = service.update(dto, id);
		if (manager == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(manager, HttpStatus.OK);
	}

	@DeleteMapping("manager/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
