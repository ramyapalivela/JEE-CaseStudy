<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Camp Registration</title>
<style>
</style>
</head>
<body>
<form action="/addCamp" modelAttribute="command" method="post">
	<div>
	<form:label path="">campNumber</form:label>
	<form:input path="campNumber"/>
	</div><div>
	<form:label path="">donationCampName</form:label>
	<form:input path="donationCampName"/>
	<form:errors path="donationCampName" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">donationCampLocation</form:label>
	<form:input path="donationCampLocation"/>
	<form:errors path="donationCampLocation" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">donationCampDate</form:label>
	<form:input path="donationCampDate"/>
	<form:errors path="donationCampDate" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">donationCampPhoneNumber</form:label>
	<form:input path="donationCampPhoneNumber"/>
	<form:errors path="donationCampPhoneNumber" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">donationCampPincode</form:label>
	<form:input path="donationCampPincode"/>
	<form:errors path="donationCampPincode" cssStyle="color:#ff0000"/>
	</div><div>
	<form:input path="" type="submit" value="Register"/>
	</div>
</form>

</body>
</html>