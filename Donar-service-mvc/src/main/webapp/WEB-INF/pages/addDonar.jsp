<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Donar</title>
</head>
<body>
<form action="/addDonar" modelAttribute="command" method="post">
	<div>
	<form:label path="">DonarId</form:label>
	<form:input path="donarId"/>
	<form:errors path="donarId" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">DonarName</form:label>
	<form:input path="donarName"/>
	<form:errors path="donarName" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">DonarAge</form:label>
	<form:input path="donarAge"/>
	<form:errors path="donarAge" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">DonarDateOfBirth</form:label>
	<form:input path="donarDateofBirth"/>
	<form:errors path="donarDateofBirth" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">DonarLocation</form:label>
	<form:input path="donarLocation"/>
	<form:errors path="donarLocation" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">DonarPincode</form:label>
	<form:input path="donarPincode"/>
	<form:errors path="donarPincode" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">DonarBloodGroup</form:label>
	<form:select path="donarBloodGroup">
	<form:option value="">A+</form:option>
	<form:option value="">A-</form:option>
	<form:option value="">B+</form:option>
	<form:option value="">B-</form:option>
	<form:option value="">O+</form:option>
	<form:option value="">O-</form:option>
	<form:option value="">AB+</form:option>
	<form:option value="">AB-</form:option>
	</form:select>
	</div><div>
	<form:label path="">DonarPhoneNumber</form:label>
	<form:input path="donarPhoneNumber"/>
	<form:errors path="donarPhoneNumber" cssStyle="color:#ff0000"/>
	</div><div>
	<form:label path="">DonarDonationDate</form:label>
	<form:input path="donarDonationDate"/>
	<form:errors path="donarDonationDate" cssStyle="color:#ff0000"/>
	</div><div>
	<form:input path="" type="submit" value="Register"/>
	</div>
</form>

</body>
</html>