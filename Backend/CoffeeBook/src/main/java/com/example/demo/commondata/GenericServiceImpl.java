package com.example.demo.commondata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.commondata.model.AbstractEntity;

public class GenericServiceImpl<T extends AbstractEntity, ID> implements GenericService<T,ID> {
	@Autowired
	private JpaRepository<T, ID> repo;
	@Override
	public List<T> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<T> findById(ID id) {
		return repo.findById(id);
	}

	@Override
	public T save(T entity) {
		return repo.save(entity);
	}

	@Override
	public T update(T entity) {
		return repo.save(entity);
	}

	@Override
	public void deleteById(ID id) {
		repo.deleteById(id);
	}

	@Override
	public T update(T entity, ID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
