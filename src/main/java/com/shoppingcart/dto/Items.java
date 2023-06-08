package com.shoppingcart.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Items 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_Id;
	private String item_Name;
	private String item_Category;
	private double item_Price;
	private int item_Quantity;
	
	@ManyToOne
	private Cart cart;

	public int getItem_Id() {
		return item_Id;
	}

	public void setItem_Id(int item_Id) {
		this.item_Id = item_Id;
	}

	public String getItem_Name() {
		return item_Name;
	}

	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}

	public String getItem_Category() {
		return item_Category;
	}

	public void setItem_Category(String item_Category) {
		this.item_Category = item_Category;
	}

	public double getItem_Price() {
		return item_Price;
	}

	public void setItem_Price(double item_Price) {
		this.item_Price = item_Price;
	}

	public int getItem_Quantity() {
		return item_Quantity;
	}

	public void setItem_Quantity(int item_Quantity) {
		this.item_Quantity = item_Quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
}
