package com.example.demo.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.store.model.Store;
import com.example.demo.store.model.StoreDistrict;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	
	@Query("SELECT "
			+ " new com.example.demo.store.model.StoreDistrict(s.district, COUNT(s)) "
			+ " FROM "
			+ " Store s "
			+ " GROUP BY "
			+ " s.district")
	List<StoreDistrict> findGroupByDistrict();
}
