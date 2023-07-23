<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to Sporty Shoes
<form action="home" method="POST">  
UserName:<span class="required-field" style="color:red">*</span> 
<input type="email" name="emailid" required="true"/><br/><br/>  
Password:<span class="required-field" style="color:red">*</span> 
<input type="password" name="pwd" required="true"/><br/><br/>  
<input type="submit" value="Login"/>  
</form>

</body>
</html>