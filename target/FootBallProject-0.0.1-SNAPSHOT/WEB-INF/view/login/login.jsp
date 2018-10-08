<?xml version = "1.0" encoding = "UTF-8"?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/css/loginStyle.css" />">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function switchLoginDiv(message) {
		var staff = document.getElementById("staffDiv");
		var member = document.getElementById("memberDiv");

		if (message == 1) {
			staff.style.display = "block";
			member.style.display = "none";

		} else if (message == 0) {
			staff.style.display = "none";
			member.style.display = "block";
		}

		function submitFunction() {
			alert("Invalid!!");
			return true;
		}

	}
</script>
<title>Login</title>
</head>
<body>

	<img src=<c:url value = "/resources/image/footballcourt.jpg" />
		class="backgroundImg" alt="football_court" />
	<H2>${message}</H2>

	<div class="loginDiv">
		<img src=<c:url value = "/resources/image/signinlogo.png" />
			class="signinImg" alt="signin_Logo" /> <input type="button"
			class="loginTypeBtn" value="Staff" onclick="switchLoginDiv(1)" /> <input
			type="button" class="loginTypeBtn" value="Member"
			onclick="switchLoginDiv(0)" />

		<div class="memberDiv" id="memberDiv">
			<form:form action="login/0" commandName="user"
				onsubmit="alert('Apple');">
				<div class="boxTitle">Member Login</div>
				<form:label path="userId" id="userIdLabel" class="txtDiv"> User Id </form:label>
				<form:input path="userId" class="inputDiv"></form:input>
				<form:label path="password" class="txtDiv"> Password</form:label>
				<form:input path="password" class="inputDiv"></form:input>
				<input type="submit" value="Login" id="submitBtn" class="submitBtn" />
			</form:form>
			<a href="register"><input type="button" class="registerBtn"
				value="Register" /></a>
		</div>

		<div class="staffDiv" id="staffDiv">
			<form:form action="login/1" commandName="user"
				onsubmit="return submitFunction();">
				<div class="boxTitle">Staff Login</div>
				<form:label path="userId" id="userIdLabel" class="txtDiv"> User Id </form:label>
				<form:input path="userId" class="inputDiv"></form:input>
				<form:label path="password" class="txtDiv"> Password</form:label>
				<form:input path="password" class="inputDiv"></form:input>
				<input type="submit" value="Login" id="submitBtn" class="submitBtn" />
			</form:form>
		</div>

	</div>
</body>
</html>