package com.example.demo.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.staff.model.AddEmpDto;
import com.example.demo.staff.model.Employee;
import com.example.demo.staff.model.UpdateEmployeeDto;
import com.example.demo.staff.repository.EmployeeRepository;
import com.example.demo.store.model.Store;
import com.example.demo.store.repository.StoreRepository;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Long> implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private StoreRepository storeRepo;

	@Override
	public Employee save(AddEmpDto dto) {
		try {
			Store store = storeRepo.findById(dto.getStoreId()).get();
			Employee emp = new Employee();
			emp.setName(dto.getName());
			emp.setAge(dto.getAge());
			emp.setPhone(dto.getPhone());
			emp.setEmail(dto.getEmail());
			emp.setGender(dto.getGender());
			emp.setAddress(dto.getAddress());
			emp.setCity(dto.getCity());
			emp.setCountry(dto.getCountry());
			emp.setSalary(dto.getSalary());
			emp.setStore(store);
			emp.setStatus("Hoạt động");
			return repo.save(emp);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public Employee update(UpdateEmployeeDto dto, long id) {
		try {
			Store store = storeRepo.findById(dto.getStoreId()).get();
			Employee emp = repo.getById(id);
			emp.setName(dto.getName());
			emp.setAge(dto.getAge());
			emp.setPhone(dto.getPhone());
			emp.setEmail(dto.getEmail());
			emp.setGender(dto.getGender());
			emp.setAddress(dto.getAddress());
			emp.setSalary(dto.getSalary());
			emp.setStore(store);
			return repo.save(emp);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

}
