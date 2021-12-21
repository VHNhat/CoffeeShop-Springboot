package com.example.demo.bill.service;


import java.util.List;

import com.example.demo.bill.model.AddBillDto;
import com.example.demo.bill.model.Bill;
import com.example.demo.bill.model.BillDto;
import com.example.demo.bill.model.SaleYear;
import com.example.demo.bill.model.UpdateBillDto;
import com.example.demo.commondata.GenericService;

public interface BillService extends GenericService<Bill, Long> {

	Bill delivery(long id);

	boolean purchase(BillDto dto);
	
	Bill update(UpdateBillDto dto, long id);

	Bill save(AddBillDto dto);

	List<Bill> findByCustomerId(long id);

	List<SaleYear> findSale();
	
}
