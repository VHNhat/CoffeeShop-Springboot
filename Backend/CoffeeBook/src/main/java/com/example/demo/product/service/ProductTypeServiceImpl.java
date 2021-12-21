package com.example.demo.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.product.model.ProductType;
import com.example.demo.product.repository.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl extends GenericServiceImpl<ProductType, Long> implements ProductTypeService {

	@Autowired
	private ProductTypeRepository repo;

	@Override
	public ProductType update(ProductType entity, Long id) {
		try {
			ProductType type = repo.getById(id);
			type.setName(entity.getName());
			type.setDescription(entity.getDescription());
			type.setPhoto(entity.getPhoto());
			return repo.save(type);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

}
