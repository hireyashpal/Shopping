package com.shoppingcart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingcart.dto.Admin;
import com.shoppingcart.dto.Customer;
import com.shoppingcart.dto.Merchant;

@WebServlet("/Loginvalidate")
public class Loginvalidate extends HttpServlet
{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
		
			String email=req.getParameter("email");
			String pass=req.getParameter("password");
			String choice=req.getParameter("choice");

			if (choice.equals("As Customer")) 
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
				EntityManager em=emf.createEntityManager();
				
				Query query=em.createQuery("select a from Customer a where customer_Email=?1 and customer_Password=?2");
				query.setParameter(1, email);
				query.setParameter(2, pass);
				
				List<Customer> customer=query.getResultList();
				
				if(customer.size()>0)
				{
					PrintWriter pout=resp.getWriter();
					pout.print("Wel-come");
					RequestDispatcher rd=req.getRequestDispatcher("login.html");
					rd.include(req, resp);
					resp.setContentType("text/html");
				}
				else
				{
					PrintWriter pout=resp.getWriter();
					pout.print("Invalid input");
					RequestDispatcher rd=req.getRequestDispatcher("login.html");
					rd.include(req, resp);
					resp.setContentType("text/html");
				}
			}
			// Check Ac a Merchant
			else if (choice.equals("As Merchant"))  
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
				EntityManager em=emf.createEntityManager();
				
				// Retrieval data from table with help of email and password.
				Query query=em.createQuery("select a from Merchant a where merchant_Email=?1 and merchant_Password=?2");
				query.setParameter(1, email);  // pass values to placeholders
				query.setParameter(2, pass);   // pass values to placeholders
				
				List<Merchant> merchant=query.getResultList();
				
				if(merchant.size()>0)
				{
					Merchant m=merchant.get(0);
					
					String s=m.getMerchant_statuse();
					
					if (s.equals("active")) 
					{
//						 Http session is created to stored Data Of Merchant.
							HttpSession httpsession=req.getSession();
							httpsession.setAttribute("Merchant",m);

							
						PrintWriter pout=resp.getWriter();
//						//pout.print("Wel-come");
						RequestDispatcher rd=req.getRequestDispatcher("Merchantoption.html");
						rd.include(req, resp);
						resp.setContentType("text/html");
					}
					else 
					{
						PrintWriter pout=resp.getWriter();
						pout.print("your account is inactive");
						RequestDispatcher rd=req.getRequestDispatcher("login.html");
						rd.include(req, resp);
						resp.setContentType("text/html");	
					}
										
				}
				else
				{
					PrintWriter pout=resp.getWriter();
					pout.print("Invalid input >>JA JA BAP KA MAL SAMJYA KYA<<<<");
					RequestDispatcher rd=req.getRequestDispatcher("login.html");
					rd.include(req, resp);
					resp.setContentType("text/html");
				}
			}
			else if(choice.equals("As Admin"))
			{
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
				EntityManager em=emf.createEntityManager();
				
				Query query=em.createQuery("select a from Admin a where admin_Email=?1 and password=?2");
				query.setParameter(1, email);
				query.setParameter(2, pass);
				
				List<Admin> customer=query.getResultList();
				
				if(customer.size()>0)
				{
//					    Http session is created to stored Data Of Admin.
					Admin a=customer.get(0);    
					HttpSession hs=req.getSession(); 
					hs.setAttribute("Admin", a);
					
					PrintWriter pout=resp.getWriter();
					//pout.print("Wel-come");
					RequestDispatcher rd=req.getRequestDispatcher("adminoption.html");
					rd.include(req, resp);
					resp.setContentType("text/html");
				}
				else
				{
					PrintWriter pout=resp.getWriter();
					pout.print("Invalid input >>>BAP KA MAL SAMJE KYA BE<<<<<");
					RequestDispatcher rd=req.getRequestDispatcher("login.html");
					rd.include(req, resp);
					resp.setContentType("text/html");
				}
			}	
		}

}
