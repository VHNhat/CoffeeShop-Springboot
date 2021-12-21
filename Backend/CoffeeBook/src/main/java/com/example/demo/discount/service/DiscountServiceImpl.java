package com.example.demo.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.discount.model.Discount;
import com.example.demo.discount.repository.DiscountRepository;

@Service
public class DiscountServiceImpl extends GenericServiceImpl<Discount, Long> implements DiscountService {

	@Autowired
	private DiscountRepository repo;

	@Override
	public Discount update(Discount entity, Long id) {
		try {
			Discount discount = repo.getById(id);
			discount.setName(entity.getName());
			discount.setPhoto(entity.getPhoto());
			discount.setQuantity(entity.getQuantity());
			discount.setValue(entity.getValue());
			discount.setExpiredDate(entity.getExpiredDate());
			return repo.save(discount);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public List<Discount> findAllWithQuantity() {
		return repo.findWithQuantity();
	}
}
