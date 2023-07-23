<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  <%@ page isELIgnored = "false" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Products</title>

<script>
	function edit() {
		document.getElementById("productlist").hidden = "hidden";
		document.getElementById("productlist-editable").removeAttribute(
				"hidden");
		document.getElementById("edit").hidden = "hidden";
	}
</script>
</head>
<body>
	<%
	String userRole = (String) session.getAttribute("userRole");
	%>
	<b>You are logged in as: <%=userRole%></b> 
	<br><br>
	********* Product Details *********
	<br>
	<br>
	<%
	if (userRole.equals("admin")) {
	%>
	<button id="edit" name="edit" onclick="edit()" style="background-color:blue;border-radius: 8px;color: white;">Edit</button>
	
	<form action='/add' method="get">
	<button id="add" name="add" type="submit" style="background-color:blue;border-radius: 8px;color: white;">Add</button>
	</form>
	
	<%
	}
	%>
	<table id="productlist" contentEditable="false" border="1" style="margin-top:15px;">
		<thead>
			<tr>
				<th>Model ID</th>
				<th>Model Name</th>
				<th>Price</th>
				<th>Color</th>
				<th>Category</th>
				<th>Gender</th>
				<th>Size</th>
				<th>Brand</th>
				<th>Details</th>
				<th>Availability</th>
				<th>Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${product.model_id}</td>
					<td>${product.model_name}</td>
					<td>${product.price}</td>
					<td>${product.color}</td>
					<td>${product.category}</td>
					<td>${product.gender}</td>
					<td>${product.size}</td>
					<td>${product.brand}</td>
					<td>${product.details}</td>
					<td>${product.availability}</td>
					<td <%if (userRole.equals("admin")) {%> contentEditable="false"
						style="background-color: rgb(240, 240, 245);" <%}%>>${product.rating}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	

			<br>
				<br> 
				<table id="productlist-editable" 	hidden="hidden" border=1">
					<thead>
						<tr>
							<th>Model ID</th>
							<th>Model Name</th>
							<th>Price</th>
							<th>Color</th>
							<th>Category</th>
							<th>Gender</th>
							<th>Size</th>
							<th>Brand</th>
							<th>Details</th>
							<th>Availability</th>
							<th>Rating</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" varStatus="status" items="${list}">
							<tr>
								<td><center><form method="GET" action="/getDetails/${product.model_id}">
									<button style="background-color:blue;border-radius: 8px;color: white;" path="model_id">
									${product.model_id}</button>
									</form>	</center>
								</td>
								<td>${product.model_name}</td>
								<td>${product.price}</td>
								<td>${product.color}</td>
								<td>${product.category}</td>
								<td>${product.gender}</td>
								<td>${product.size}</td>
								<td>${product.brand}</td>
								<td>${product.details}</td>
								<td>${product.availability}</td>
								<td>${product.rating}</td>
								<td><center><form method="GET" action="/delete/${product.model_id}">
									<button style="background-color:red;border-radius: 8px;color: white;" path="model_id">
									Delete</button>
									</form></center></td>
							</tr>
						</c:forEach>	
					</tbody>
				</table>
</body>
</html>
