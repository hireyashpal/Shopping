<%@page import="com.shoppingcart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
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
Wel_Come To Delete Product

	<%
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Query query=em.createQuery("select a from Product a");
	 
	List<Product> product=query.getResultList();
%>
<%if(product.size()>0){%>
	<table>
		<tr>
			<th>Product Id</th>
			<th>Product Category</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Stock</th>
			<th>Block Merchant</th>	
		</tr>
<%
	for(Product p: product){
%>	
	<tr>
			<th><%= p.getProduct_Id() %></th>
			<th><%= p.getProduct_Category() %></th>
			<th><%= p.getProduct_Name() %></th>
			<th><%= p.getProduct_Price() %></th>
			<th><%= p.getProduct_Stock() %></th>
            <td><a href="DeleteP.jsp?id=<%= p.getProduct_Id() %>">Delete Product</a></td>		
    </tr>
<%} %>
</table>
<%}else{%>
<h1 align="center" style="color: red;">No Product For Delete</h1>
<%}%>
	%>


</body>
</html>