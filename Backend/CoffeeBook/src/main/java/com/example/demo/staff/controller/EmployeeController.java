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

import com.example.demo.staff.model.AddEmpDto;
import com.example.demo.staff.model.Employee;
import com.example.demo.staff.model.UpdateEmployeeDto;
import com.example.demo.staff.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("employees")
	public ResponseEntity<Object> Get() {
		List<Employee> emps = service.findAll();
		return new ResponseEntity<>(emps, HttpStatus.OK);
	}

	@GetMapping("employee/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<Employee> emp = service.findById(id);
		if (emp == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PostMapping("employee/create")
	public ResponseEntity<Object> Post(@RequestBody AddEmpDto dto) {
		Employee newEmp = service.save(dto);
		if (newEmp == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newEmp, HttpStatus.OK);
	}

	@PutMapping("employee/update/{id}")
	public ResponseEntity<Object> Put(@RequestBody UpdateEmployeeDto dto, @PathVariable("id") long id) {
		Employee emp = service.update(dto, id);
		if (emp == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@DeleteMapping("employee/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
