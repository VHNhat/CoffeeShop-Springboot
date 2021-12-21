package com.example.demo.role.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.example.demo.role.model.Role;
import com.example.demo.role.service.RoleService;

@RestController
/* @RequestMapping("/api/role") */
public class RoleController {
	@Autowired
	private RoleService service;

	@GetMapping("role")
	public ResponseEntity<Object> Get() {
		List<Role> roles = service.findAll();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@GetMapping("role/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<Role> role = service.findById(id);
		if (role == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(role, HttpStatus.OK);
	}

	@PostMapping("role/add")
	public ResponseEntity<Object> Post(@Valid @RequestBody Role role) {
		Role newRole = service.save(role);
		if (newRole == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newRole, HttpStatus.OK);
	}

	@PutMapping("role/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") Long id, @RequestBody Role role) {
		Role updatedRole = service.update(role, id);
		if (updatedRole == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedRole, HttpStatus.OK);
	}

	@DeleteMapping("role/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") Long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
