<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscription View</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/memberStyle.css" />">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />

<style type="text/css">
.container {
	margin-top: 60px;
	float: left;
	padding: 20px;
	width: 100%;
}

#editTable{
	width: 40%;
}

#editTable input {
	width: 100%;
}
</style>
</head>
<body>
	<%@include file="navBar.jsp"%>



	<div class="container">
		<c:if test= "${!empty editSubscription}">
			<div class="editContainer">
				<table class="table table-striped" align="center" id="editTable">
					<form:form action="updateSubscription" commandName="editSubscription" method = "post">
					<tr><td colspan = 2 style = "color: #5d6d7e; font-weight: bold; text-align: center; "> Edit Subscription</td></tr>
					<tr>
						<th>Subscription Id</th>
						<td><form:input path="subscriptionId" value = "${editSubscription.subscriptionId}" readonly="true" />
						</td>
					</tr>
					<tr>
						<th>MemberShip Type</th>
						<td><form:input type="text"
								path="memberShipType"
								value="${editSubscription.memberShipType}" /></td>
					</tr>
					<tr>
						<th>Member Type</th>
						<td><form:input type="text"
								path="memberType"
								value="${editSubscription.memberType}" /></td>
					<tr>
						<th>Price</th>
						<td><form:input type="text" path="price"
								value="${editSubscription.price}" /></td>
					</tr>
					<tr>
						<td colspan = 2><input type="submit" value="Edit" class = "btn btn-primary" /></td>
					</tr>
					</form:form>
				</table>
			</div>
			</c:if>

			<table align="center" class="table table-striped" id="viewTable">

				<tr>
					<th>Subscription Id</th>
					<th>MemberShip Type</th>
					<th>Member Type</th>
					<th>Price</th>
					<th>Edit</th>
				</tr>

				<c:forEach items="${subscriptionList}" var="subscription">
					<tr>
						<td><c:out value="${subscription.subscriptionId}" /></td>
						<td><c:out value="${subscription.memberShipType}" /></td>
						<td><c:out value="${subscription.memberType}" /></td>
						<td><c:out value="${subscription.price}" /></td>
						<td><a
							href="editSubscription?subscriptionId=${subscription.subscriptionId}"><input
								type="button" value="Edit" class = "btn btn-primary"/></a></td>
					</tr>
				</c:forEach>
			</table>
	</div>

</body>
</html>