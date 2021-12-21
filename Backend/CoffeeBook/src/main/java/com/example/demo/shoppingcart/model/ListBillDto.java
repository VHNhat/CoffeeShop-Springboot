package com.example.demo.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/*@Entity
@Table(name = "ShoppingCart_Product")*/
@Getter
@Setter
public class ListBillDto {

	@JsonProperty("ShoppingCartId")
	private long shoppingCartId;

	@JsonProperty("ProductId")
	private long productId;

	@JsonProperty("TitleSize")
	private String titleSize;

	@JsonProperty("Count")
	private int count;

	public long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getTitleSize() {
		return titleSize;
	}

	public void setTitleSize(String titleSize) {
		this.titleSize = titleSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

}
