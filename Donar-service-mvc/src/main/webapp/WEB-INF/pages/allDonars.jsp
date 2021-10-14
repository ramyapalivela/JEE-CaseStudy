<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Donars</title>
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
<th>Donar Id</th>
<th>Donar Name</th>
<th>Donar Age</th>
<th>Donar DateofBirth</th>
<th>Donar Location</th>
<th>Donar Pincode</th>
<th>Donar BloodGroup</th>
<th>Donar PhoneNumber</th>
<th>Donar DonationDate</th>
</tr>
<c:forEach items ="${alldonars}" var ="eachItem">
<td>${eachItem.donarId}</td>
<td>${eachItem.donarName}</td>
<td>${eachItem.donarAge}</td>
<td>${eachItem.donarDateofBirth}</td>
<td>${eachItem.donarLocation}</td>
<td>${eachItem.donarPincode}</td>
<td>${eachItem.donarBloodGroup}</td>
<td>${eachItem.donarPhoneNumber}</td>
<td>${eachItem.donarDonationDate}</td>
</c:forEach>
</table>
</body>
</html>