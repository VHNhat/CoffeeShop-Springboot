package com.example.demo.bill.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bill.model.AddBillDto;
import com.example.demo.bill.model.Bill;
import com.example.demo.bill.model.BillDto;
import com.example.demo.bill.model.SaleExcelExporter;
import com.example.demo.bill.model.SaleYear;
import com.example.demo.bill.model.UpdateBillDto;
import com.example.demo.bill.service.BillService;

@RestController
public class BillController {
	@Autowired
	private BillService service;

	@GetMapping("bill")
	public ResponseEntity<Object> Get() {
		List<Bill> bills = service.findAll();
		return new ResponseEntity<>(bills, HttpStatus.OK);
	}

	@GetMapping("bill/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		List<Bill> bill = service.findByCustomerId(id);
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	
	@GetMapping("bill/sales")
	public ResponseEntity<Object> GetSale() {
		List<SaleYear> bill = service.findSale();
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	
	@GetMapping("sale/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=DoanhThuNam_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<Bill> listBills = service.findAll();
         
        SaleExcelExporter excelExporter = new SaleExcelExporter(listBills);
         
        excelExporter.export(response);    
    }  

	@PostMapping("bill/add")
	public ResponseEntity<Object> Post(@RequestBody AddBillDto dto) {
		Bill newBill = service.save(dto);
		if (newBill == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(newBill, HttpStatus.OK);
	}

	@PostMapping("bill/purchase")
	public ResponseEntity<Object> Purchase(@RequestBody BillDto dto) {
		boolean purchase = service.purchase(dto);
		if (purchase)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("bill/edit/{id}")
	public ResponseEntity<Object> Put(@PathVariable("id") long id, @RequestBody UpdateBillDto dto) {
		Bill updatedBill = service.update(dto, id);
		if (updatedBill == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(updatedBill, HttpStatus.OK);
	}

	@PutMapping("bill/delivery/{id}")
	public ResponseEntity<Object> Delivery(@PathVariable("id") long id) {
		Bill deliveried = service.delivery(id);
		if (deliveried == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(deliveried, HttpStatus.OK);
	}

	@DeleteMapping("bill/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
