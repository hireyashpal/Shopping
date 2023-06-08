package com.shoppingcart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingcart.dto.Customer;
import com.shoppingcart.dto.Merchant;

@WebServlet("/savedata")
public class SaveMerchantCustomer extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String mono=req.getParameter("mono");
		long mono1=Long.parseLong(mono);
		String choice=req.getParameter("choice");
		
		if (choice.equals("createaccountasmerchant")) 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			
			
			Merchant merchant=new Merchant();
			
			merchant.setMerchant_Name(name);
			merchant.setMerchant_email(email);
			merchant.setMerchant_Password(password);
			merchant.setMerchant_MONO(mono1);
			merchant.setMerchant_statuse("inactive");
			
			et.begin();
			em.persist(merchant);
			et.commit();
			
			PrintWriter poup=resp.getWriter();
			poup.print("Merchant Account is created");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");		
		}
		else if(choice.equals("createaccountascustomer"))
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			Customer customer=new Customer();
			
			customer.setCustomer_Name(name);
			customer.setCustomer_Email(email);
			customer.setCustomer_Password(password);
			customer.setCustomer_MONO(mono1);
			customer.setCustomer_statuse("active");
			
			et.begin();
			em.persist(customer);
			et.commit();
			
			PrintWriter poup=resp.getWriter();
			poup.print("Customer Account is created");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
