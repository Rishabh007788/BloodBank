
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="special" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>blood_bank_manager_home</title>
</head>
<body>
<h1>blood_bank_manager_home</h1>

 
<a href="fetch_all_requests"><button>All Requests</button></a><br><br> 
<a href="fetch_all_donations"><button>All Donations</button></a> <br><br>

<form action="check_donation" method="post">
<h1>check donation:</h1>
Donation  id: <input type="text" name="donation_id">
<button type="submit">Submit</button>
</form>

	

</body>
</html>

