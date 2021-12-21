package com.example.demo.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.supplier.model.Supplier;
import com.example.demo.supplier.repository.SupplierRepository;

@Service
public class SupplierServiceImpl extends GenericServiceImpl<Supplier, Long> implements SupplierService {

	@Autowired
	private SupplierRepository repo;

	@Override
	public Supplier update(Supplier entity, Long id) {
		try {
			Supplier supp = repo.getById(id);
			supp.setName(entity.getName());
			supp.setAddress(entity.getAddress());
			supp.setCity(entity.getCity());
			supp.setCountry(entity.getCountry());
			supp.setDescription(entity.getDescription());
			supp.setPhone(entity.getPhone());
			supp.setUrl(entity.getUrl());
			return repo.save(entity);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}
}
