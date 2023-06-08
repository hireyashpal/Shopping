package com.shoppingcart.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.shoppingcart.dto.Product;

@WebServlet("/StoreProduct")
public class StoreProduct extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		
		
		String category=req.getParameter("Product_Category");
		String name=req.getParameter("Product_Name");
		double price=Double.parseDouble(req.getParameter("Product_Price"));
		int    stock=Integer.parseInt(req.getParameter("Product_Stock"));

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Product product=new Product();
		product.setProduct_Category(category);
		product.setProduct_Name(name);
		product.setProduct_Price(price);
		product.setProduct_Stock(stock);
		
		product.setMerchant(null);
		//session
		
		
		
		
		
//		et.begin();
//		em.persist(product);
//		et.commit();
//		
		
		
		
		
	
	}
}
	