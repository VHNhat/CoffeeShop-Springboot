package com.example.demo.product.service;

import com.example.demo.commondata.GenericService;
import com.example.demo.product.model.AddProductDto;
import com.example.demo.product.model.Product;
import com.example.demo.product.model.UpdateProductDto;

public interface ProductService extends GenericService<Product, Long> {

	Product save(AddProductDto dto);

	Product update(UpdateProductDto dto, long id);

}
