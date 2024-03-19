<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="blood_request" method="post">
	City:<input name="city" placeholder="enter your city.."><br>
	Blood group:<select name="blood_group">
					<option value="A positive">A positive</option>
					<option value="A negative">A negative</option>
					<option value="B positive">B positive</option>
					<option value="B negative">B negative</option>
					<option value="O positive">O positive</option>
					<option value="O negative">O negative</option>
					<option value="AB positive">AB positive</option>
					<option value="AB negative">AB negative</option>
				</select>
	Blood amount:<select name="blood_amount">
					<option value="1u">1 unit</option>
					<option value="2u">2 unit</option>
					<option value="3u">3 unit</option>
					<option value="4u">4 unit</option>
					<option value="5u">5 unit</option>
					<option value="6u">6 unit</option>
					<option value="7u">7 unit</option>
					<option value="8u">8 unit</option>
				</select>	<br><br>
				
				<input type="submit"> <input type="reset">
	
	</form>
</body>
</html>
