<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.shoppingcart.dto.Merchant"%>
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
   
   <%
   		       int id=Integer.parseInt(request.getParameter("id"));
   
   				EntityManagerFactory emf=Persistence.createEntityManagerFactory("yash");
   				EntityManager em=emf.createEntityManager();
   				EntityTransaction et=em.getTransaction();
   				
   				Merchant merchant=em.find(Merchant.class, id);
				
   				if(merchant.getMerchant_statuse().equals("Active"))
   				{
   					
   				}
   				
   				
   				
   				
				et.begin();
				em.remove(merchant);
				et.commit();
				
				PrintWriter pout=response.getWriter();
				pout.print(merchant.getMerchant_Name()+" is Deleted");
				RequestDispatcher rd=request.getRequestDispatcher("DeleteMerchant.jsp");
				rd.include(request, response);
				response.setContentType("text/html");
				
			
   %>
  
</body>
</html>