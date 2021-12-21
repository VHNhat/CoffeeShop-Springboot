package com.example.demo.commondata;

import java.util.List;
import java.util.Optional;

import com.example.demo.commondata.model.AbstractEntity;

public interface GenericService<T extends AbstractEntity, ID> {
	List<T> findAll();
	Optional<T> findById(ID id);
	T save(T entity);
	T update(T entity);
	T update(T entity, ID id);
	void deleteById(ID id);
}
