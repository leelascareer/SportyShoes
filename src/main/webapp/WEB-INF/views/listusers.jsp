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
	*********Users in the System*********
	<br>
	<br>
	
	<form action="/listusers">
    Filter By Name: <input type="text" name="keyword" id="keyword" size="50" required />
    <input type="submit" value="Search" />
    &nbsp;
    <input type="button" value="Reset" id="btnClear" onclick="clearSearch()" />
	</form>
	
	<table id="userlist" contentEditable="false" border="1" style="margin-top:15px;">
		<thead>
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${list}">
				<tr>
					<td>${user.emailid}</td>
					<td>${user.f_name}</td>
					<td>${user.l_name}</td>
					<td>${user.age}</td>
					<td>${user.gender}</td>
					<td>${user.emailid}</td>
					<td>${user.ph}</td>
					<td>${user.role}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
