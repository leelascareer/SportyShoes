<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ss.entity.Product"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%
	String userRole= (String)session.getAttribute("userRole");
	//Product selectedProduct = (Product) request.getAttribute("selectedProduct");
	%>
	<b>You are logged in as: <%= userRole%></b>
	<br>
	<br>
	
	<div style="align:center;">
		<center>***********EDIT PRODUCT DETAILS***********</center>
	<form:form action="/update/${selectedProduct.model_id}" method="get" modelAttribute="productRequest">
	
	<label for="model_id"><b>Model Id:</b></label>				
	<text id="model_id">${selectedProduct.model_id}</text>
	<br><br>
	<label for="model_name"><b>Model Name:</b></label>		
	<form:input id="model_name" type="text" path="model_name" value="${selectedProduct.model_name}"/>
	<br><br>
	<label for="price"><b>Price:</b></label>		
	<form:input id="price" type="double" path="price" min="500.00" max="7999.99" step="0.01" value="${selectedProduct.price}"></form:input>
	<br><br>
	<label for="color"><b>Colour:</b></label>		
	<form:input id="color" type="text" path="color" value="${selectedProduct.color}"></form:input>
	<br><br>
	<label for="category"><b>Category:</b></label>		
	<form:select id="category" type="text" path="category" value="${selectedProduct.category}">
			<option selected>${selectedProduct.category}</option>
			<option <c:if test="${selectedProduct.category eq 'Casual Wear'}"> hidden="hidden" </c:if>>Casual Wear</option>
			<option <c:if test="${selectedProduct.category eq 'Formal Wear'}"> hidden="hidden" </c:if>>Formal Wear</option>
			<option <c:if test="${selectedProduct.category eq 'Kids Wear'}"> hidden="hidden" </c:if>>Kids Wear</option>
			<option <c:if test="${selectedProduct.category eq 'Party Wear'}"> hidden="hidden" </c:if>>Party Wear</option>
			<option <c:if test="${selectedProduct.category eq 'Running'}"> hidden="hidden" </c:if>>Running</option>
			<option <c:if test="${selectedProduct.category eq 'School'}"> hidden="hidden" </c:if>>School</option>
			<option <c:if test="${selectedProduct.category eq 'Walking'}"> hidden="hidden" </c:if>>Walking </option>
	</form:select>
	<label for="gender"><b>Gender</b></label>		
	<form:select id="gender" path="gender">
			<option selected>${selectedProduct.gender}</option>
			<option <c:if test="${selectedProduct.gender eq 'Male'}"> hidden="hidden" </c:if>>Male</option>
			<option <c:if test="${selectedProduct.gender eq 'Female'}"> hidden="hidden" </c:if>>Female </option>
			<option <c:if test="${selectedProduct.gender eq 'Unisex'}"> hidden="hidden" </c:if>>Unisex</option>
	</form:select>
	<br><br>
	<label for="size"><b>Size</b></label>		
	<form:input type="number" path= "size"  min="2" max="12" step="1" value="${selectedProduct.size}"></form:input>
	<label for="brand" cols="15"><b>Brand:</b></label>		
	<form:input id="brand" type="text" path="brand" value="${selectedProduct.brand}"></form:input>
	<label for="availability" ><b>Availability:</b></label>		
	<form:input id="Availability" cols="5" type="number" min="0" max="30" step="1" path="availability" value="${selectedProduct.availability}"></form:input>
	<br><br>
	<label for="details"><b>Details:</b></label>		
	<form:input id="details" cols="50" maxlength="50" type="text" path="details" value="${selectedProduct.details}"></form:input>
	<br><br>
	<label><b>Rating</b></label>		
	<text>${selectedProduct.rating}</text>
		<br><br>
	<form:button style="background-color:blue;border-radius: 8px;color: white;" id="update" name="update" path="model_id">Update</form:button>
	</form:form>
	</div>
						
</body>
</html>