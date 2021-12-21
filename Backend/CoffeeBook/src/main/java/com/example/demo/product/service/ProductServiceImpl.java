package com.example.demo.product.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.product.model.AddProductDto;
import com.example.demo.product.model.Product;
import com.example.demo.product.model.ProductType;
import com.example.demo.product.model.UpdateProductDto;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.product.repository.ProductTypeRepository;
import com.example.demo.supplier.model.Supplier;
import com.example.demo.supplier.repository.SupplierRepository;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {

	@Autowired
	private ProductRepository repo;
	@Autowired
	private ProductTypeRepository typeRepo;
	@Autowired
	private SupplierRepository suppRepo;

	@Override
	public Product save(AddProductDto dto) {
		try {
			ProductType type = typeRepo.findById(dto.getProductTypeId()).get();
			Supplier supp = suppRepo.findById(dto.getSupplierId()).get();
			Product pro = new Product();
			pro.setProductType(type);
			pro.setSupplier(supp);
			pro.setCreatedDate(LocalDateTime.now());
			pro.setName(dto.getName());
			pro.setDescription(dto.getDescription());
			pro.setPhoto(dto.getPhoto());
			pro.setPrice(dto.getPrice());
			pro.setSize(dto.getSize());
			return repo.save(pro);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public Product update(UpdateProductDto dto, long id) {
		try {
			ProductType type = typeRepo.findById(dto.getProductTypeId()).get();
			Supplier supp = suppRepo.findById(dto.getSupplierId()).get();
			Product pro = repo.getById(id);
			pro.setName(dto.getName());
			pro.setDescription(dto.getDescription());
			pro.setPhoto(dto.getPhoto());
			pro.setPrice(dto.getPrice());
			pro.setSize(dto.getSize());
			pro.setProductType(type);
			pro.setSupplier(supp);
			return repo.save(pro);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

}
