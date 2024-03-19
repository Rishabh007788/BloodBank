<%@page import="blood.dto.Requests"%>
<%@page import="blood.dto.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userhome</title>
</head>
<body>
<%-- Check if reqmsg is not null and display it as an alert --%>
<!--<% if (request.getAttribute("donmsg") != null) { %>
    <script>
        alert("${donmsg}");
    </script>
    <%request.setAttribute("donmsg", null); %>
<% } %>  -->
<h1> ${userDetails.getName()} welcome to blood bank</h1>
<h1>${reqmsg}</h1>
<h1>${donmsg}</h1>
    
    <a href="request.jsp">request blood</a>
    <a href="donate.jsp">donate blood</a>
    
    
    
</body>
</html>

