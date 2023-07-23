<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  <%@ page isELIgnored = "false" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Orders</title>
<script>
    function clearSearch() {
        window.location = "/listusers";
    }
</script>
</head>
<body>
	<%
	String userRole = (String) session.getAttribute("userRole");
	%>
	<b>You are logged in as: <%=userRole%></b> 
	<br><br>
	********* Order List *********
	<br>
	<br>
	<form action="/listorders">
    Filter By Category: <input type="text" name="keyword" id="keyword" size="50" required />
    <input type="submit" value="Search" />
    &nbsp;
    <input type="button" value="Reset" id="btnClear" onclick="clearSearch()" />
	</form>
	<table id="orderlist" contentEditable="false" border="1" style="margin-top:15px;">
		<thead>
			<tr>
				<th>Order ID</th>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Model ID</th>
				<th>Model Name</th>
				<th>Category</th>
				<th>Size</th>
				<th>Color</th>
				<th>Price</th>
				<th>Date of Purchase</th>
				<th>Order Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="${list}">
				<tr>
					<td>${order.order_id}</td>
					<td>${order.userid}</td>
					<td>${order.f_name}</td>
					<td>${order.l_name}</td>
					<td>${order.model_id}</td>
					<td>${order.model_name}</td>
					<td>${order.category}</td>
					<td>${order.size}</td>
					<td>${order.color}</td>
					<td>${order.price}</td>
					<td>${order.dateofpurchase}</td>
					<td>${order.status}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		

</body>
</html>
