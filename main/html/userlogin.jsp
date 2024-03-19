<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>blood_bank_user_login</title>
</head>
<body>
    
    
	<form action="user_login">
		email: <input type="email" name="email" placeholder="enter email id.."><br><br>
		password: <input type="password" name="password" placeholder="enter password.."><br><br>
		<p>${msg}</p><br><br>
		<input type="submit" > <input type="reset" >
	</form>
</body>
</html>