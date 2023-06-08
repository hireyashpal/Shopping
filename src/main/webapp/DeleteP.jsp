<%@page import="com.shoppingcart.dto.Product"%>
<%@page import="com.shoppingcart.dto.Merchant"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      Wel_Come To Delete
      <%
      		String id=request.getParameter("id");
      		
      		int id1=Integer.parseInt(id);
      		
      		EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
      		EntityManager em=emf.createEntityManager();
      		EntityTransaction et=em.getTransaction();
      		
      		//Merchant merchant=em.find(Merchant.class, id);
      		 Product producr=em.find(Product.class, id1);
      		
      		 et.begin();
      		 em.remove(producr);
      		 et.commit();
      		 
      		 
      		 RequestDispatcher rd=request.getRequestDispatcher("viewProduct.jsp"); 	
      		 rd.forward(request, response);
      	
      %>
      
      
      
</body>
</html>