package com.example.demo.staff.service;

import com.example.demo.commondata.GenericService;
import com.example.demo.staff.model.AddEmpDto;
import com.example.demo.staff.model.Employee;
import com.example.demo.staff.model.UpdateEmployeeDto;

public interface EmployeeService extends GenericService<Employee, Long> {

	Employee save(AddEmpDto dto);

	Employee update(UpdateEmployeeDto dto, long id);

}
