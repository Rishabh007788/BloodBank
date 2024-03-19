<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blood Bank  Blood Donate</title>
</head>
<body>

<form action="blood_donate" method="post">
	City:<input name="city" placeholder="enter your city.."><br><br>
	your Blood group:<select name="blood_group">
					<option value="A positive">A positive</option>
					<option value="A negative">A negative</option>
					<option value="B positive">B positive</option>
					<option value="B negative">B negative</option>
					<option value="O positive">O positive</option>
					<option value="O negative">O negative</option>
					<option value="AB positive">AB positive</option>
					<option value="AB negative">AB negative</option>
				</select><br><br>
	are you on any medication:<select name="medication">
					<option value="1">yes</option>	
					<option value="0">no</option>
				</select><br><br>
	family history of genetic disorder:<select name="genetic_disorder">
					<option value="1">yes</option>
					<option value="0">no</option>					
				</select><br><br>
	Select one date for donation:<input type="date" name="target_date">	<br><br>
				
	<input type="submit"> <input type="reset">
	
	</form>

</body>
</html>