<%@page import="com.shoppingcart.dto.Merchant"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
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
	Wel_Come
	
	<%		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
		EntityManager em=emf.createEntityManager();
		
		Query query=em.createQuery("select a from Merchant a");
		
		List<Merchant> merchant=query.getResultList();
	%>
	<%
		if(merchant.size()>0)
		{
	%>
		<table border="2px" cellpadding="5px" cellspacing="0">
			<tr>
			    <th>merchant_Id</th	>
				<th>merchant_Name</th>
				<th>merchant_email</th>
				<th>merchant_Password</th>
				<th>merchant_MONO</th>
				<th>merchant_statuse</th>
			</tr>	
		
	<%
		for(Merchant m: merchant)
		{
	%>
			<tr>
			    <td><%=m.getMerchant_Id() %></td>
				<td><%=m.getMerchant_Name() %></td>
				<td><%=m.getMerchant_email() %></td>
				<td><%=m.getMerchant_Password() %></td>
				<td><%=m.getMerchant_MONO() %></td>
				
	<%
				if(m.getMerchant_statuse().equals("inactive")){
	%>				
				<td style="color: red;"><%=m.getMerchant_statuse() %></td>
			</tr>
	<%}else{ %>		
		<td style="color: green;"><%=m.getMerchant_statuse() %></td>
			</tr>
	<%} %>		
	<%}%>
	</table>
	<%}%>
	
</body>
</html>



