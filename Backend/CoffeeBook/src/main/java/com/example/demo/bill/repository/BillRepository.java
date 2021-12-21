package com.example.demo.bill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.bill.model.Bill;
import com.example.demo.bill.model.SaleYear;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	@Query("SELECT b FROM Bill b WHERE customer_id = ?1")
	List<Bill> findByCusId(long id);

	@Query("SELECT "
			+ " new com.example.demo.bill.model.SaleYear(MONTH(b.createdDate), SUM(b.totalPrice))"
			+ " FROM Bill b "
			+ " WHERE b.validated = 1 "
			+ " GROUP BY MONTH(b.createdDate) "
			+ " ORDER BY MONTH(b.createdDate) asc")
	List<SaleYear> GetSale();
}
