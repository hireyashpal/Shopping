<%@page import="com.shoppingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	Are you ready to add a product? <br><br>
	
	<form action="StoreProduct.jsp" method="post">
		
		<label>Product Category</label>
		<input type="text" name="Product_Category" id="Product_Category" ><br><br>
	
		<label>Product Name</label>
		<input type="text" name="Product_Name" id="Product_Name" ><br><br>
	
		<label>Product price</label>
		<input type="text" name="Product_Price" id="Product_Price" ><br><br>

		<label>Product Stock</label>
		<input type="text" name="Product_Stock" id="Product_Stock" ><br><br>
	
		<input type="submit" value="Add Product">
	</form>
</body>
</html>