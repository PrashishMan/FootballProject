<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscription Payment</title>
<link rel="Stylesheet" type="text/css"
	href="<c:url value = "/resources/css/paySubscriptionPageStyle.css"/>" />
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

	<div class="descriptionDiv">
		<div class="imageDiv">
			<img src=<c:url value = "/resources/image/coins.jpg" /> alt="coins" />
		</div>
		<H1 style="text-align: center; margin-top: 30px;">Subscription</H1>
		<table class="table table-striped"
			style="width: 400px; margin: 10px; position: relative; float: left; border: 2px solid #17202A; border-radius: 10px;">
			<tr>
				<td>Name</td>
				<td>${member.firstName}${member.lastName}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${member.city},${member.street}</td>
			</tr>
			<tr>
				<td>Member Type</td>
				<td>${memberType}</td>
			</tr>

			<tr>
				<td>Membership</td>
				<td>${member.memberShipType}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${member.email}</td>
			</tr>

			<tr>
				<td>Subscription Amount</td>
				<td>&pound ${subscriptionAmount}</td>
			</tr>
			
		</table>
		<a href="updateMember?userId=${member.userId}"><input type="button" value="Confirm"
			style="width: 80%; height: 30px; margin-bottom: 10px; margin-left: 9%" /></a>
	</div>



</body>
</html>