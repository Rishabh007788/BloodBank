<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="special" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>All Blood Donations Applications</h1>
<c:if test="${not empty donations}">

		<table border="1" >
			<tr>
				<th>user id</th>
				<th>donation id</th>
				<th>Blood group</th>
				<th>Blood amount</th>
				<th>City</th>
				<th>Apply date</th>
				<th>Status</th>
				<th>Change status</th>
				<th>up-gradation date</th>
				<th>Reason</th>
				<th>Change Reason</th>
			</tr>
			
			<c:forEach var="req" items="${donations}">
				
				<tr>
					<td>${req.getUserDetails().getId()}</td>
					<td>${req.getDonation_id()}</td>
					<td>${req.getBlood_group()}</td>
					<td>${req.getBlood_amount()}</td>
					<td>${req.getCity()}</td>
					<td>${req.getDate_of_apply()}</td>
					<td>${req.getStatus()}</td>
<td>
    <form action="" method="post">
        <input type="hidden" name="donation_id" value="${req.getDonation_id()}">
        <select name="status">
            <option value="">Change status</option>
            <option value="Active">Active</option>
            <option value="Pending">Pending</option>
            <option value="Complete">Complete</option>
            <option value="Failed">Failed</option>
        </select>
        <button type="submit">Submit</button>
    </form>
</td>
					<td>${req.getDate_of_complt()}</td>
					<td>${req.getReason()}</td>
					
	<td><form action="" method="post">
        <input type="hidden" name="donation_id" value="${req.getDonation_id()}">
        <select name="reason">
            <option value="">Change reason</option>
            <option value="doner_absent">doner_absent</option>
            <option value="medication">medication</option>
            <option value="genetic_dis">genetic_diss</option>
            
        </select>
        <button type="submit">Submit</button>
    </form></td>
				</tr>
			
			</c:forEach>
		</table>
	</c:if>
</body>
</html>