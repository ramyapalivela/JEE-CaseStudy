<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Camp Details</title>
<style>
table,th,td{
border:2px solid blue;
margin-left: auto;
margin-right:auto;
border-collapse: collapse;

}
</style>
</head>
<body>
<table>
<tr>
<th>Camp Number</th>
<th>Donation Camp Name</th>
<th>Donation Camp Location</th>
<th>Donation Camp Date</th>
<th>Donation Camp PhoneNumber</th>
<th>Donation Camp Pincode</th>
</tr>
<c:forEach items ="${camp}" var ="eachItem">
<td>${eachItem.campNumber}</td>
<td>${eachItem.donationCampName}</td>
<td>${eachItem.donationCampLocation}</td>
<td>${eachItem.donationCampDate}</td>
<td>${eachItem.donationCampPhoneNumber}</td>
<td>${eachItem.donationCampPincode}</td>
</c:forEach>
</table>
</body>
</html>