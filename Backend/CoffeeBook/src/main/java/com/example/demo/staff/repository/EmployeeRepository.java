package com.example.demo.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.staff.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
