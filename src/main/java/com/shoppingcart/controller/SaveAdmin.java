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

import com.shoppingcart.dto.Admin;

@WebServlet("/SaveAdmin")
public class SaveAdmin extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Admin admin=new Admin();
		admin.setAdmin_Email(email);
		admin.setPassword(pass);
		
		et.begin();
		em.persist(admin);
		et.commit();
		
		PrintWriter pout=resp.getWriter();
		pout.print("Admin Account Created");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
}	
}
