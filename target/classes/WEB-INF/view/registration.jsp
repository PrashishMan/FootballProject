<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/registrationStyle.css" />">
<script type="text/javascript">
	function checkFunction() {

		if (firstName.value == "") {
			alert("Please enter the first Name!!");
			return false;
		}

		else if (lastName.value == "") {
			alert("Please enter the last Name!!");
			return false;
		}

		else if (dateOfBirth.value == "") {
			alert("Please enter the Date of Birth !!");
			return false;
		}

		else if (gender.value == "") {
			alert("Please enter the Gender!!");
			return false;
		}

		else if (city.value == "") {
			alert("Please enter the City!!");
			return false;
		}

		else if (street.value == "") {
			alert("Please enter the Street!!");
			return false;
		}

		else if (email.value == "") {
			alert("Please enter the Email!!");
			return false;
		}

		else {
			alert("Please Visit your closest center for UserId and Password!!");
			return true;
		}
	}
</script>
</head>
<body>
	<img src=<c:url value = "/resources/image/footballcourt.jpg" />
		class="backgroundImg" alt="football_court" />
	<div class="container">
		<div class="registrationTitle">Registration</div>
		<form:form action="registerMember" method="post" commandName="member"
			onSubmit="return checkFunction();">
			<table>
				<tr>
					<td class="label">First Name</td>
					<td class="label">Last Name</td>
				</tr>
				<tr>

					<td><form:input path="firstName" id="firstName" /></td>
					<td><form:input path="lastName" id="lastName" /></td>

				</tr>
				<tr>
					<td class="label">Date of Birth</td>
					<td class="label">Gender</td>
				</tr>
				<tr>
					<td><form:input path="dateOfBirth" id="dateOfBirth" /></td>
					<td><form:input path="gender" id="gender" /></td>
				</tr>
				<tr>
					<td class="label">City</td>
					<td class="label">Street</td>
				</tr>
				<tr>
					<td><form:input path="city" id="city" /></td>
					<td><form:input path="street" id="street" /></td>
				</tr>

				<tr>
					<td class="label">Membership</td>
					<td><form:radiobutton path="memberShipType"
							value="Partial Member" id="partialMember" /><span class="option">Partial</span>
						<form:radiobutton path="memberShipType" value="Full Member"
							id="fullMember" checked="checked" /><span class="option">Full
					</span></td>
				</tr>

				<tr>
					<td class="label">Organizer</td>
					<td><form:radiobutton path="isOrganizer" value="true"
							id="yesOrganizer" /><span class="option">Yes</span> <form:radiobutton
							path="isOrganizer" value="false" id="notOrganizer"
							checked="checked" /><span class="option">No</span></td>
				</tr>

				<tr>
					<td class="label">Email</td>

				</tr>
				<tr>
					<td colspan=2><form:input path="email" style="width : 90%"
							id="email" /></td>
				</tr>
				<tr>

					<td><input type="submit" value="Done" class="registrationBtn" /></td>
					<td><input type="button" value="Cancel"
						class="registrationBtn" /></td>

				</tr>

			</table>

		</form:form>
	</div>

</body>
</html>