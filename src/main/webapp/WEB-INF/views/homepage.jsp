<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<h1>
		<center>*******SPORTY SHOES******</center>
	</h1>
		
	<%
	String userRole= (String)session.getAttribute("userRole");
	%>
	<b>You are logged in as: <%= userRole%></b>
	<br>
	<br>
	<%
	if (userRole.equals("admin")) {
	%> 
	<div style="margin-bottom:15px">
	<form action="listusers">
	<input type="submit" value="View All Users" />
	</form>
	</div>
	<br><br>
	<div style="margin-bottom:15px">
	<form action="changepassword.jsp">
	<input type="submit" value="Change Password" />
	</form>
	</div>
	<br><br>
	<div style="margin-bottom:15px">
	<form action="listorders">
	<input type="submit" value="View All Orders" />
	</form>
	</div>
	<%
	}
	%>
	
	<br>
	<div style="margin-bottom:15px">
	<form action="listproducts">
	<input type="submit" value="View All Products" />
	</form>
	</div>
	
	
	
	<jsp:include page="footer.jsp" />	
	
</body>
</html>
