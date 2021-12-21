package com.example.demo.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.supplier.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
