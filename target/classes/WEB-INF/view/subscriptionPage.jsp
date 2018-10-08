<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="<c:out value ="resources/css/subscriptionPageStyle.css" />"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscription Page</title>

<script type="text/javascript">
	function switchSubscriptionDiv(message) {
		var subscriptionContainer = document
				.getElementById("subscriptionContainer");
		var subscriptionRemainderContainer = document
				.getElementById("subscriptionRemainderContainer");
		var subscriptionUnpaidContainer = document
				.getElementById("subscriptionUnpaidContainer");

		if (message == 0) {
			subscriptionContainer.style.display = "block";
			subscriptionRemainderContainer.style.display = "none";
			subscriptionUnpaidContainer.style.display = "none";
		} else if (message == 1) {
			subscriptionContainer.style.display = "none";
			subscriptionRemainderContainer.style.display = "block";
			subscriptionUnpaidContainer.style.display = "none";
		} else if (message == 2) {
			subscriptionContainer.style.display = "none";
			subscriptionRemainderContainer.style.display = "none";
			subscriptionUnpaidContainer.style.display = "block";
		}

		function submitFunction() {
			alert("Invalid!!");
			return true;
		}

	}
</script>

<style type="text/css">
.subscriptionContainer, .subscriptionRemainderContainer,
	.subscriptionUnpaidContainer {
	margin: 10px;
	border: 4px solid #34495E;
	margin-top: 20px;
	display: none;
}

.subscriptionContainer {
	display: block;
}

#optionBtn {
	font-weight: bold;
	color: #34495e;
	width: 31%;
	float: left;
	margin-left: 1.7%;
	padding-top: 10px;
	margin-top: 10px;
}

.buttonsDiv {
	background-color: #34495e;
	width: 98.4%;
	float: left;
	padding: 2px;
	margin: 10px;
}
</style>
</head>
<body>

	<div class="title">

		<c:if test="${sessionScope.department == 'Administrator'}">
			<%@include file="navBar.jsp"%>
		</c:if>
		<a href="/FootBallProject/viewSubscriptionPage"><input
			type="button" name="addMember" value="Subscription"
			class="btn btn-normal"
			style="float: right; margin: 7px 10px; background: #F4F6F7; color: #85929E; font-weight: bold; margin-top: 58px;" /></a>
	</div>

	<div class="buttonsDiv">
		<input type="button" value="Subscription Cleared"
			onclick="switchSubscriptionDiv(0)" class="btn btn-default"
			id="optionBtn" /> <input type="button" value="Subscription Due"
			onclick="switchSubscriptionDiv(1)" class="btn btn-default"
			id="optionBtn" /> <input type="button" value="Subscription Unpaid"
			onclick="switchSubscriptionDiv(2)" class="btn btn-default"
			id="optionBtn" />

	</div>

	<div class="subscriptionContainer" id="subscriptionContainer">
		<table class="table table-striped">
			<tr>
				<th>Payment Id</th>
				<th>Subscription Date</th>
				<th>Player FirstName</th>
				<th>Player LastName</th>
				<th>Member Type</th>
				<th>Membership</th>
				<th>SubscriptionAmount</th>
			</tr>
			<c:forEach items="${clearedSubscriber}" var="subscriptionPaid">
				<tr>
					<td><c:out value="${subscriptionPaid.paymentId}" /></td>
					<td><fmt:formatDate
							value="${subscriptionPaid.subscriptionDate}" type="both"
							pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${subscriptionPaid.memberId.firstName}" /></td>
					<td><c:out value="${subscriptionPaid.memberId.lastName}" /></td>
					<td><c:out
							value="${subscriptionPaid.subscriptionId.memberType}" /></td>
					<td><c:out
							value="${subscriptionPaid.subscriptionId.memberShipType}" /></td>
					<td><c:out value="${subscriptionPaid.subscriptionId.price}" /></td>
				</tr>
			</c:forEach>

		</table>
	</div>


	<div class="subscriptionRemainderContainer"
		id="subscriptionRemainderContainer">
		<table class="table table-striped">
			<tr>
				<th>Payment Id</th>
				<th>Subscription Date</th>
				<th>Player FirstName</th>
				<th>Player LastName</th>
				<th>Member Type</th>
				<th>Membership</th>
				<th>SubscriptionAmount</th>
				<th>Payment</th>
			</tr>
			<c:forEach items="${dueTrialSubscriber}" var="dueTrialSubscriber">
				<tr>
					<td><c:out value="${dueTrialSubscriber.paymentId}" /></td>
					<td><fmt:formatDate
							value="${dueTrialSubscriber.subscriptionDate}" type="both"
							pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${dueTrialSubscriber.memberId.firstName}" /></td>
					<td><c:out value="${dueTrialSubscriber.memberId.lastName}" /></td>
					<td><c:out
							value="${dueTrialSubscriber.subscriptionId.memberType}" /></td>
					<td><c:out
							value="${dueTrialSubscriber.subscriptionId.memberShipType}" /></td>
					<td><c:out value="${dueTrialSubscriber.subscriptionId.price}" /></td>
					<td><a
						href="paySubscription?userId=${dueTrialSubscriber.memberId.userId}"><input
							type="button" value="Pay" style="width: 100%;" /></a></td>
				</tr>
			</c:forEach>

		</table>
	</div>


		<div class="subscriptionUnpaidContainer"
			id="subscriptionUnpaidContainer">
			<table class="table table-striped">
				<tr>
					<th>Payment Id</th>
					<th>Subscription Date</th>
					<th>Player FirstName</th>
					<th>Player LastName</th>
					<th>Member Type</th>
					<th>Membership</th>
					<th>SubscriptionAmount</th>
					<th>Payment</th>
				</tr>
				<c:forEach items="${paymentDueMembers}" var="paymentDueMembers">
					<tr>
						<td><c:out value="${paymentDueMembers.paymentId}" /></td>
						<td><fmt:formatDate
								value="${paymentDueMembers.subscriptionDate}" type="both"
								pattern="yyyy-MM-dd" /></td>
						<td><c:out value="${paymentDueMembers.memberId.firstName}" /></td>
						<td><c:out value="${paymentDueMembers.memberId.lastName}" /></td>
						<td><c:out
								value="${paymentDueMembers.subscriptionId.memberType}" /></td>
						<td><c:out
								value="${paymentDueMembers.subscriptionId.memberShipType}" /></td>
						<td><c:out value="${paymentDueMembers.subscriptionId.price}" /></td>
						<td><a
							href="paySubscription?userId=${paymentDueMembers.memberId.userId}">
								<input type="button" value="Pay" style="width: 100%" />
						</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
</body>
</html>