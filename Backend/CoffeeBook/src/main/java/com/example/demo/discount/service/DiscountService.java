package com.example.demo.discount.service;

import java.util.List;

import com.example.demo.commondata.GenericService;
import com.example.demo.discount.model.Discount;

public interface DiscountService extends GenericService<Discount, Long> {

	List<Discount> findAllWithQuantity();

}
