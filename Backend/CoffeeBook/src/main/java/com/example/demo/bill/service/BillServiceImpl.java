package com.example.demo.bill.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bill.model.AddBillDto;
import com.example.demo.bill.model.Bill;
import com.example.demo.bill.model.BillDto;
import com.example.demo.bill.model.SaleYear;
import com.example.demo.bill.model.UpdateBillDto;
import com.example.demo.bill.repository.BillRepository;
import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.customer.model.Customer;
import com.example.demo.customer.repository.CustomerRepository;
import com.example.demo.discount.model.Discount;
import com.example.demo.discount.repository.DiscountRepository;
import com.example.demo.product.model.Product;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.shoppingcart.model.ShoppingCart;
import com.example.demo.shoppingcart.model.ShoppingCart_Product;
import com.example.demo.shoppingcart.model.CheckoutKey;
import com.example.demo.shoppingcart.model.ListBillDto;
import com.example.demo.shoppingcart.repository.ShoppingCartProductRepository;
import com.example.demo.shoppingcart.repository.ShoppingCartRepository;

@Service
public class BillServiceImpl extends GenericServiceImpl<Bill, Long> implements BillService {
	@Autowired
	private BillRepository repo;
	@Autowired
	private ShoppingCartRepository cartRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ShoppingCartProductRepository checkoutRepo;
	@Autowired
	private DiscountRepository discountRepo;
	@Override
	public Bill delivery(long id) {
		try {
			Bill bill = repo.getById(id);
			bill.setValidated(1);
			bill.setStatus("Đã thanh toán");
			return repo.save(bill);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public boolean purchase(BillDto dto) {
		try {
			
			if(dto.isCheckDiscount()) {
				Discount discount = discountRepo.getById(dto.getDiscountId());
				discount.setQuantity(discount.getQuantity()-1);
			}
			
			Customer customer = customerRepo.findById(dto.getCustomerId()).get();
			Bill bill = new Bill();
			bill.setAddress(dto.getAddress());
			bill.setName(dto.getName());
			bill.setNote(dto.getNote());
			bill.setPayBy(dto.getPayBy());
			bill.setPhone(dto.getPhone());
			bill.setTotalPrice(dto.getTotalPrice());
			bill.setCreatedDate(LocalDateTime.now());
			bill.setCustomer(customer);
			bill.setStatus("Nhận đơn");
			if (dto.getTime().equals(""))
				bill.setTime("20-30 phút");
			else
				bill.setTime(dto.getTime());
			repo.save(bill);
			ShoppingCart cart = new ShoppingCart();
			cart.setCustomer(customer);
			cart.setProductQuantity(dto.getListBill().size());
			cart.setCreatedDate(LocalDateTime.now());
			cartRepo.save(cart);
			for (ListBillDto item : dto.getListBill()) {
				CheckoutKey key = new CheckoutKey(item.getShoppingCartId(), item.getProductId());
				ShoppingCart_Product checkout = new ShoppingCart_Product(key);
				Product pro = productRepo.findById(item.getProductId()).get();
				checkout.setProduct(pro);
				checkout.setShoppingCart(cart);
				checkout.setCreatedDate(LocalDateTime.now());
				checkout.setCount(item.getCount());
				checkout.setTitleSize(item.getTitleSize());
				checkoutRepo.save(checkout);
			}

			if (bill == null || cart == null)
				return false;
			return true;
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
			return false;
		}
	}

	@Override
	public Bill update(UpdateBillDto dto, long id) {
		try {
			Customer customer = customerRepo.findById(dto.getCustomerId()).get();
			Bill updated = repo.getById(id);
			updated.setAddress(dto.getAddress());
			updated.setName(dto.getName());
			updated.setNote(dto.getNote());
			updated.setValidated(dto.getValidated());
			updated.setStatus(dto.getStatus());
			updated.setPayBy(dto.getPayBy());
			updated.setPhone(dto.getPhone());
			updated.setTime(dto.getTime());
			updated.setTotalPrice(dto.getTotalPrice());
			updated.setCustomer(customer);
			return repo.save(updated);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public Bill save(AddBillDto dto) {
		try {
			Customer customer = customerRepo.findById(dto.getCustomerId()).get();
			Bill bill = new Bill();
			bill.setCustomer(customer);
			bill.setCreatedDate(LocalDateTime.now());
			bill.setStatus("Nhận đơn");
			bill.setAddress(dto.getAddress());
			bill.setNote(dto.getNote());
			bill.setName(dto.getName());
			bill.setPayBy(dto.getPayBy());
			bill.setPhone(dto.getPhone());
			bill.setTime(dto.getTime());
			bill.setTotalPrice(dto.getTotalPrice());
			return repo.save(bill);
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}

	}

	@Override
	public List<Bill> findByCustomerId(long id) {
		Optional<Customer> cus = customerRepo.findById(id);
		List<Bill> bill = repo.findByCusId(cus.get().getId());
		return bill;
	}

	@Override
	public List<SaleYear> findSale() {
		return repo.GetSale();
	}
	
	
}
