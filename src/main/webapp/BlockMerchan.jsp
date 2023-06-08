<%@page import="com.shoppingcart.dto.Merchant"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
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
		
		Query query=em.createQuery("select a from Merchant a where merchant_statuse='active'");
		
		List<Merchant> merchant=query.getResultList();
	%>
	<%
	  if(merchant.size()>0)
	  {
	%>
	<table border="2px" cellpadding="5px" cellspacing="0">
		<tr>
			<td>merchant_Id</td>
			<td>merchant_Name</td>
			<td>merchant_email</td>
			<td>merchant_Password</td>
			<td>merchant_MONO</td>
			<td>merchant_statuse</td>
			<td>Block Merchant</td>
		</tr>
	<%
	    for(Merchant m : merchant){
	%>
		<tr>
			<td><%= m.getMerchant_Id() %></td>
			<td><%= m.getMerchant_Name() %></td>
			<td><%= m.getMerchant_email()%></td>
			<td><%= m.getMerchant_Password() %></td>
			<td><%= m.getMerchant_MONO() %></td>
			<td><%= m.getMerchant_statuse() %></td>
			<td><a href="Block.jsp?id=<%= m.getMerchant_Id() %>"  onclick="eo()">Block Merchant</a></td>
		</tr>
		<script type="text/javascript">
		
		function eo() 
		{
			
			alert("Are you sure to BLOCK this Merchant account?");
		}
		

	</script>
	<%}%>
	</table>
	<%} %>
	
</body>
</html>