<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="com.shoppingcart.dto.Product"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.shoppingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Wel_Come Store Product
	
	<%			
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
				EntityManager        em=emf.createEntityManager();
				EntityTransaction    et=em.getTransaction();
	
		
				String product_Category=request.getParameter("Product_Category");
				String product_Name=request.getParameter("Product_Name");
				double product_Price=Double.parseDouble(request.getParameter("Product_Price"));
				int product_Stock=Integer.parseInt(request.getParameter("Product_Stock"));
		
				Merchant merchant=(Merchant)session.getAttribute("Merchant");
				String name=merchant.getMerchant_Name();
				
				Product product=new Product();
				product.setProduct_Category(product_Category);
				product.setProduct_Name(product_Name);
				product.setProduct_Price(product_Price);
				product.setProduct_Stock(product_Stock);
				
				product.setMerchant(merchant);
				
				ArrayList p1=new ArrayList();
				p1.add(product);
				merchant.setProduct(p1);
						
				
				et.begin();
				em.persist(product);
				em.persist(merchant);
				et.commit();
			
				
				PrintWriter pout=response.getWriter();
				pout.print("Product is stored ");
				RequestDispatcher rd=request.getRequestDispatcher("Merchantoption.html");
				rd.include(request, response);
				response.setContentType("text/html");
				
				
				
				
	%>
	
</body>
</html>