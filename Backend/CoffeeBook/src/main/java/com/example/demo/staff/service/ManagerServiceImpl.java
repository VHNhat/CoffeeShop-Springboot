package com.example.demo.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.staff.model.AddManagerDto;
import com.example.demo.staff.model.Manager;
import com.example.demo.staff.model.UpdateManagerDto;
import com.example.demo.staff.repository.ManagerRepository;
import com.example.demo.store.model.Store;
import com.example.demo.store.repository.StoreRepository;

@Service
public class ManagerServiceImpl extends GenericServiceImpl<Manager, Long> implements ManagerService {

	@Autowired
	private ManagerRepository repo;
	@Autowired
	private StoreRepository storeRepo;

	@Override
	public Manager save(AddManagerDto dto) {
		try {
			Store store = storeRepo.findById(dto.getStoreId()).get();
			Manager manager = new Manager();
			manager.setName(dto.getName());
			manager.setAge(dto.getAge());
			manager.setPhone(dto.getPhone());
			manager.setEmail(dto.getEmail());
			manager.setGender(dto.getGender());
			manager.setAddress(dto.getAddress());
			manager.setCity(dto.getCity());
			manager.setCountry(dto.getCountry());
			manager.setSalary(dto.getSalary());
			manager.setBonus(dto.getBonus());
			manager.setStore(store);
			manager.setStatus("Hoạt động");
			return repo.save(manager);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public Manager update(UpdateManagerDto dto, long id) {
		try {
			Store store = storeRepo.findById(dto.getStoreId()).get();
			Manager manager = new Manager();
			manager.setName(dto.getName());
			manager.setAge(dto.getAge());
			manager.setPhone(dto.getPhone());
			manager.setEmail(dto.getEmail());
			manager.setGender(dto.getGender());
			manager.setAddress(dto.getAddress());
			manager.setCity(dto.getCity());
			manager.setCountry(dto.getCountry());
			manager.setSalary(dto.getSalary());
			manager.setBonus(dto.getBonus());
			manager.setStore(store);
			return repo.save(manager);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}
}
