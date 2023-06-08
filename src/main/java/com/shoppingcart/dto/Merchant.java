package com.shoppingcart.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Merchant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int merchant_Id;
	private String merchant_Name;
	private String merchant_email;
	private String merchant_Password;
	private long merchant_MONO;
	private String merchant_statuse;
	
	@ManyToOne
	Admin admin;
	
	@OneToMany
	private List<Product> product;

	public int getMerchant_Id() {
		return merchant_Id;
	}

	public void setMerchant_Id(int merchant_Id) {
		this.merchant_Id = merchant_Id;
	}

	public String getMerchant_Name() {
		return merchant_Name;
	}

	public void setMerchant_Name(String merchant_Name) {
		this.merchant_Name = merchant_Name;
	}

	public String getMerchant_email() {
		return merchant_email;
	}

	public void setMerchant_email(String merchant_email) {
		this.merchant_email = merchant_email;
	}

	public String getMerchant_Password() {
		return merchant_Password;
	}

	public void setMerchant_Password(String merchant_Password) {
		this.merchant_Password = merchant_Password;
	}

	public long getMerchant_MONO() {
		return merchant_MONO;
	}

	public void setMerchant_MONO(long merchant_MONO) {
		this.merchant_MONO = merchant_MONO;
	}

	public String getMerchant_statuse() {
		return merchant_statuse;
	}

	public void setMerchant_statuse(String merchant_statuse) {
		this.merchant_statuse = merchant_statuse;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
}
