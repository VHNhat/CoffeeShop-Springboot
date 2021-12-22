package com.example.demo.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.staff.model.Manager;
import com.example.demo.staff.repository.ManagerRepository;
import com.example.demo.store.model.AddStoreDto;
import com.example.demo.store.model.Store;
import com.example.demo.store.model.StoreDistrict;
import com.example.demo.store.model.UpdateStoreDto;
import com.example.demo.store.repository.StoreRepository;

@Service
public class StoreServiceImpl extends GenericServiceImpl<Store, Long> implements StoreService {

	@Autowired
	private StoreRepository repo;
	@Autowired
	private ManagerRepository managerRepo;

	@Override
	public Store save(AddStoreDto dto) {
		try {
			Manager manager = managerRepo.findById(dto.getManagerId()).get();
			Store store = new Store();
			store.setStoreName(dto.getStoreName());
			store.setManager(manager);
			store.setPhone(dto.getPhone());
			store.setDescription(dto.getDescription());
			store.setAddress(dto.getAddress());
			store.setCountry(dto.getCountry());
			store.setDistrict(dto.getDistrict());
			store.setLinkGG(dto.getLinkGG());
			store.setPhoto(dto.getPhoto());
			return repo.save(store);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public Store update(UpdateStoreDto dto, long id) {
		try {
			Manager manager = managerRepo.findById(dto.getManagerId()).get();
			Store store = repo.getById(id);
			store.setStoreName(dto.getStoreName());
			store.setManager(manager);
			store.setPhone(dto.getPhone());
			store.setDescription(dto.getDescription());
			store.setAddress(dto.getAddress());
			store.setCountry(dto.getCountry());
			store.setDistrict(dto.getDistrict());
			store.setLinkGG(dto.getLinkGG());
			store.setPhoto(dto.getPhoto());
			return repo.save(store);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public List<StoreDistrict> findByDistrict() {
		return repo.findGroupByDistrict();
	}
}
