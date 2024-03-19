
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>donation_application</title>
</head>
<body>
<h1>Donation Application</h1>
<c:if test="${not empty donation}">

		<table border="1" >
			<tr>
				<th>user id</th>
				<th>donation id</th>
				<th>Blood group</th>
				<th>Blood amount</th>
				<th>genetic-dis</th>
				<th>medication</th>
				<th>City</th>
				<th>Apply date</th>
				<th>Target date</th>
				<th>Status</th>
				
				<th>up-gradation date</th>
				<th>Reason</th>
				<th>set_blood amount</th>
				<th>Change status</th>
				<th>Change Reason</th>
			</tr>
			
			
				
				<tr>
					<td>${donation.getUserDetails().getId()}</td>
					<td>${donation.getDonation_id()}</td>
					<td>${donation.getBlood_group()}</td>
					<td>${donation.getBlood_amount()}</td>
					<td>${donation.getGenetic_disorder()}</td>
					<td>${donation.getMedication() }</td>
					<td>${donation.getCity()}</td>
					<td>${donation.getDate_of_apply().withNano(0).withSecond(0).withMinute(0).withHour(0)}</td>
					<td>${donation.getTarget_date()}</td>
					<td>${donation.getStatus()}</td>

					<td>${donation.getDate_of_complt().withNano(0).withSecond(0).withMinute(0).withHour(0)}</td>
					<td>${donation.getReason()}</td>
	
	<td><form action="set_blood_amount" method="post">
		<input type="hidden" name="donation_id" value="${donation.getDonation_id()}">
		<input type="text" name="blood_amount" placeholder="amount ml..">
		<button type="submit">Submit</button>
	</form></td>
					
	<td>
    <form action="donation_status_chng" method="post">
        <input type="hidden" name="donation_id" value="${donation.getDonation_id()}">
        <select name="status">
            <option value="">Change</option>
            <option value="Active">Active</option>
            <option value="Pending">Pending</option>
            <option value="Complete">Complete</option>
            <option value="Failed">Failed</option>
        </select>
        <button type="submit">Submit</button>
    </form>
</td>
					
	<td><form action="donation_reason_chng" method="post">
        <input type="hidden" name="donation_id" value="${donation.getDonation_id()}">
        <select name="reason">
            <option value="">Change</option>
            <option value="doner_absent">doner_absent</option>
            <option value="medication">medication</option>
            <option value="genetic_dis">genetic_diss</option>
            
        </select>
        <button type="submit">Submit</button>
    </form></td>
				</tr>
			
			
		</table>
	</c:if>
	<c:if test="${empty donation}"> <h1>Request not found</h1> </c:if>
</body>
</html>