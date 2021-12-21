package com.example.demo.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CheckoutKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ShoppingCartId")
	private Long shoppingcartId;
	@Column(name = "ProductId")
	private Long productId;

	
	
	public CheckoutKey() {
		super();
	}

	public CheckoutKey(Long shoppingcartId, Long productId) {
		this.shoppingcartId = shoppingcartId;
		this.productId = productId;
	}

	public Long getShoppingcartId() {
		return shoppingcartId;
	}

	public void setShoppingcartId(Long shoppingcartId) {
		this.shoppingcartId = shoppingcartId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
