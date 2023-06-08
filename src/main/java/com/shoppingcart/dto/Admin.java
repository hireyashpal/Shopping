package com.shoppingcart.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_Id;
	@Column(unique = true)
	private String admin_Email;
	private String password;
	
	
	@OneToMany
	private List<Merchant> merchant;
	
	
	public int getAdmin_Id() 
	{
		return admin_Id;
	}
	public void setAdmin_Id(int admin_Id) 
	{
		this.admin_Id = admin_Id;
	}
	public String getAdmin_Email() 
	{
		return admin_Email;
	}
	public void setAdmin_Email(String admin_Email) 
	{
		this.admin_Email = admin_Email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public List<Merchant> getMerchant() {
		return merchant;
	}
	public void setMerchant(List<Merchant> merchant) {
		this.merchant = merchant;
	}
	
	
	
	
	
	
	
	
	
}
