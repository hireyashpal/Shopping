package com.shoppingcart.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int customer_Id;
   private String customer_Name;
   @Column(unique = true)
   private String customer_Email;
   private String customer_Password;
   @Column(unique = true)
   private long customer_MONO;
   private String customer_statuse;
   public String getCustomer_statuse() {
	return customer_statuse;
}

public void setCustomer_statuse(String customer_statuse) {
	this.customer_statuse = customer_statuse;
}

@OneToOne
   private Cart cart;

public int getCustomer_Id() {
	return customer_Id;
}

public void setCustomer_Id(int customer_Id) {
	this.customer_Id = customer_Id;
}

public String getCustomer_Name() {
	return customer_Name;
}

public void setCustomer_Name(String customer_Name) {
	this.customer_Name = customer_Name;
}

public String getCustomer_Email() {
	return customer_Email;
}

public void setCustomer_Email(String customer_Email) {
	this.customer_Email = customer_Email;
}

public String getCustomer_Password() {
	return customer_Password;
}

public void setCustomer_Password(String customer_Password) {
	this.customer_Password = customer_Password;
}

public long getCustomer_MONO() {
	return customer_MONO;
}

public void setCustomer_MONO(long customer_MONO) {
	this.customer_MONO = customer_MONO;
}

public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}
   
   
}
