<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="special" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blood_requests</title>
</head>
<body>
<h1>All Blood Requests</h1>
<c:if test="${not empty requests}">

		<table border="1" >
			<tr>
				<th>Name</th>
				<th>user id</th>
				<th>request id</th>
				<th>Blood group</th>
				<th>Blood amount</th>
				<th>City</th>
				<th>Date of Request</th>
				<th>Status</th>
				<th>Change status</th>
				<th>Date of up-gradation</th>
				<th>Reason</th>
				<th>Change Reason</th>
			</tr>
			
			<c:forEach var="req" items="${requests}">
				
				<tr>
					<td>${req.getUserDetails().getName()}</td>
					<td>${req.getUserDetails().getId()}</td>
					<td>${req.getRequest_id()}</td>
					<td>${req.getBlood_group()}</td>
					<td>${req.getBlood_amount()}</td>
					<td>${req.getCity()}</td>
					<td>${req.getDateofRequest().withNano(0).withSecond(0)}</td>
					<td>${req.getStatus()}</td>
			
					<td>
    <form action="active" method="post">
        <input type="hidden" name="request_id" value="${req.getRequest_id()}">
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
					<td>${req.getDateofComplition()}</td>
					<td>${req.getReason()}</td>
					
	<td><form action=reasonchng method="post">
        <input type="hidden" name="request_id" value="${req.getRequest_id()}">
        <select name="reason">
            <option value="">Change reason</option>
            <option value="recipient_absent">recipient_absent</option>
            <option value="blood_unavailable">blood_unavailable</option>
            
        </select>
        <button type="submit">Submit</button>
    </form></td>
				</tr>
			
			</c:forEach>
		</table>
	</c:if>
</body>
</html>