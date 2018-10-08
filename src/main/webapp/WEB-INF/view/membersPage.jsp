<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="<c:url value="/resources/css/memberStyle.css" />">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Members</title>

<script type="text/javascript">
	function switchLoginDiv(message) {
		var allMember = document.getElementById("allContainer");
		var newMember = document.getElementById("newContainer");

		if (message == 1) {
			allMember.style.display = "none";
			newMember.style.display = "block";

		} else if (message == 0) {
			allMember.style.display = "block";
			newMember.style.display = "none";
		}

		function submitFunction() {
			alert("Invalid!!");
			return true;
		}

	}
</script>

</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.department == 'Administrator'}">
			<div class="title">
				<%@include file="navBar.jsp"%>
			</div>
		</c:when>
		<c:when test="${sessionScope.department != 'Rececptionist'}">
			<div class="title">
				<span class="pageHeading">MemberPage</span> <a
					href="/FootBallProject/"><input type="button" name="search"
					value="Home" class="btn btn-default"
					style="float: right; margin: 7px 10px" /></a> <a
					href="/FootBallProject/logout"><input type="button"
					name="search" value="logout" class="btn btn-danger"
					style="float: right; margin: 7px 10px" /></a>
			</div>
		</c:when>
	</c:choose>
	<c:if
		test="${sessionScope.department == 'Secretary' || sessionScope.department == 'Administrator'}">
		<form:form action="/FootBallProject/registerMember" method="POST">
			<table class="table table-striped" id="memberInsertTable">
				<form:input path="userId" readonly="true" type="hidden" />
				<tr>
					<td colspan=2
						style="text-align: center; font-weight: bold; background: #34495e; color: #FBFCFC;">Add
						Member</td>
				</tr>

				<tr>
					<th><Strong><form:label path="firstName">First Name: </form:label></Strong></th>
					<td><form:input path="firstName" value="${member.firstName}" />
				</tr>
				<tr>
					<th><Strong><form:label path="lastName">Last Name: </form:label></Strong></th>
					<td><form:input path="lastName" value="${member.lastName}" />
				</tr>
				<c:if test="${!empty member.password }">
					<tr>
						<th><Strong><form:label path="password">Password: </form:label></Strong></th>
						<td><form:input path="password" value="${member.password}" />
					</tr>
				</c:if>
				<tr>
					<th><Strong><form:label path="city">City: </form:label></Strong></th>
					<td><form:input path="city" value="${member.city}" />
				</tr>
				<tr>
					<th><Strong><form:label path="street">Street: </form:label></Strong></th>
					<td><form:input path="street" value="${member.street}" /></td>
				</tr>
				<tr>
					<th><Strong><form:label path="gender">Gender: </form:label></Strong></th>
					<td><form:select path="gender">

							<c:choose>
								<c:when test="${member.gender == 'Male'}">
									<option value="Male" selected>Male</option>
									<option value="Female">Female</option>
								</c:when>
								<c:when test="${member.gender == 'Female'}">
									<option value="Female" selected>Female</option>
									<option value="Male">Male</option>
								</c:when>
								<c:otherwise>
									<option value=""></option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</c:otherwise>
							</c:choose>
						</form:select></td>
				</tr>
				<tr>
					<th><Strong><form:label path="dateOfBirth">Date Of Birth: </form:label></Strong></th>
					<td><fmt:formatDate value="${member.dateOfBirth}"
							pattern="yyyy/MM/dd" var="DOB" /> <form:input type="text"
							path="dateOfBirth" value="${DOB}" /></td>
				</tr>
				<tr>
					<th class="memberShipType"><Strong>Membership:</Strong></th>
					<td><c:choose>
							<c:when test="${member.memberShipType ==  'Full Member'}">
								<form:radiobutton path="memberShipType" value="Partial Member"
									id="partialMember"
									style="float: left; margin-left: 25px; width: 9%; background: red;" />
								<span class="option" style="margin-left: 5px; float: left;">Partial</span>

								<form:radiobutton path="memberShipType" value="Full Member"
									id="fullMember" checked="checked"
									style="margin-left: 18px; width: 8%" /> Full
						</c:when>
							<c:otherwise>
								<form:radiobutton path="memberShipType" value="Partial Member"
									id="partialMember" checked="checked"
									style="float: left; margin-left: 25px; width: 9%; background: red;" />
								<span class="option" style="margin-left: 5px; float: left;">Partial</span>

								<form:radiobutton path="memberShipType" value="Full Member"
									id="fullMember" style="margin-left: 18px; width: 8%" /> Full						
						</c:otherwise>

						</c:choose></td>


				</tr>

				<tr>
					<th class="isOrganizer"><Strong>Organizer</Strong></th>
					<td><c:choose>
							<c:when test="${member.isOrganizer}">

								<form:radiobutton path="isOrganizer" value="true"
									id="yesOrganizer" style="margin-left: 20px; width: 10%"
									checked="checked" />
								<span class="option" style="margin-left: 5px;">Yes</span>
								<form:radiobutton path="isOrganizer" value="false"
									id="notOrganizer" style="margin-left: 20px; width: 10%" />
								<span class="option" style="margin-left: 5px;">No</span>
							</c:when>
							<c:otherwise>
								<form:radiobutton path="isOrganizer" value="true"
									id="yesOrganizer" style="margin-left: 20px; width: 10%" />
								<span class="option" style="margin-left: 5px;">Yes</span>
								<form:radiobutton path="isOrganizer" value="false"
									id="notOrganizer" checked="checked"
									style="margin-left: 20px; width: 10%" />
								<span class="option" style="margin-left: 5px;">No</span>
							</c:otherwise>

						</c:choose></td>
				</tr>

				<tr>
					<th><Strong><form:label path="email">Email: </form:label></Strong></th>
					<td><form:input path="email" value="${member.email}" /></td>
				</tr>
				<c:if test="${!empty member.userId}">
					<c:if test="${!empty teams}">
						<tr>
							<th><Strong><form:label path="teamName.teamName">Team Name: </form:label></Strong></th>
							<td><form:select path="teamName.teamName">

									<option value=null></option>

									<c:forEach items="${teams}" var="team">

										<c:choose>
											<c:when test="${team.teamName == member.teamName.teamName }">
												<option value="${team.teamName}" selected>${team.teamName}</option>
											</c:when>
											<c:otherwise>
												<option value="${team.teamName}">${team.teamName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>


								</form:select></td>
						</tr>
					</c:if>
				</c:if>
				<tr>
					<td colspan=2><input type="submit" value="Done"
						class="btn btn-primary" style="width: 100%; color: #fbfcfc" /></td>

				</tr>

			</table>
		</form:form>


	</c:if>
	<div class="displayContainer">
		<c:if
			test="${sessionScope.department == 'Secretary' || sessionScope.department == 'Administrator'}">
			<input type="button" value="New Members" onclick="switchLoginDiv(1)"
				class="btn btn-default"
				style="font-weight: bold; color: #34495e; width: 48%; float: left; margin-left: 1%;" />
			<input type="button" value="All Member" onclick="switchLoginDiv(0)"
				class="btn btn-default"
				style="font-weight: bold; color: #34495e; width: 48%; float: left; margin-left: 2%;" />


			<div class="newContainer" id="newContainer">

				<div class="innerContainer">
					<div class="searchBan">
						<span
							style="float: left; color: #34495E; padding: 10px; font-size: 16px; font-weight: bold;">
							New Member</span> <input type="button" value="Search"
							class="btn btn-default" style="float: right; margin: 4px" /> <input
							type="text" name="search" placeholder="search"
							class="searchInput" />

					</div>
					<table class="table table-striped">

						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>City</th>
							<th>Street</th>
							<th>Gender</th>
							<th>MemberType</th>
							<th>Membership</th>
							<th>PlayerType</th>

							<th colspan="2">Subscription</th>

						</tr>

						<c:forEach items="${newMembersList}" var="member">
							<tr>
								<td><c:out value="${member.firstName}" /></td>
								<td><c:out value="${member.lastName}" /></td>
								<td><c:out value="${member.city}" /></td>
								<td><c:out value="${member.street}" /></td>
								<td><c:out value="${member.gender}" /></td>
								<td><c:choose>
										<c:when
											test="${(currentDate.year - member.dateOfBirth.year) < 15}">
											<c:out value="Junior Member" />
										</c:when>
										<c:otherwise>
											<c:out value="Senior Member" />
										</c:otherwise>
									</c:choose></td>

								<td><c:out value="${member.memberShipType}" /></td>
								<td><c:choose>
										<c:when test="${member.isOrganizer}">
											<c:out value="Organizer" />
										</c:when>
										<c:otherwise>
											<c:out value="Member" />
										</c:otherwise>
									</c:choose></td>

								<td><a href="paySubscription?userId=${member.userId}"><input
										type="button" value="Paid" style="width: 100%"></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>
		</c:if>


		<div class="allContainer" id="allContainer">
			<div class="innerContainer">
				<div class="searchBan">
					<span
						style="float: left; color: #34495E; padding: 10px; font-size: 16px; font-weight: bold;">
						Members</span> <input type="button" value="search"
						class="btn btn-default" style="float: right; margin: 4px" /> <input
						type="text" name="search" placeholder="search" class="searchInput" />

				</div>
				<table class="table table-striped" style="text-align: center;">

					<tr>
						<th>UserId</th>
						<th>Password</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>City</th>
						<th>Street</th>
						<th>Gender</th>
						<th>MemberType</th>
						<th>Membership</th>
						<th>PlayerType</th>
						<th>Team Name</th>
						<th>Subscription Status</th>

						<th>Edit</th>

					</tr>


					<c:forEach items="${members}" var="member">
						<tr>
							<td><c:out value="${member.userId}" /></td>
							<td><c:out value="${member.password}" /></td>
							<td><c:out value="${member.firstName}" /></td>
							<td><c:out value="${member.lastName}" /></td>
							<td><c:out value="${member.city}" /></td>
							<td><c:out value="${member.street}" /></td>
							<td><c:out value="${member.gender}" /></td>


							<td><c:choose>
									<c:when
										test="${(currentDate.year - member.dateOfBirth.year) < 15}">
										<c:out value="Junior Member" />
									</c:when>
									<c:otherwise>
										<c:out value="Senior Member" />
									</c:otherwise>
								</c:choose></td>

							<td><c:out value="${member.memberShipType}" /></td>

							<td><c:choose>
									<c:when test="${member.isOrganizer}">
										<c:out value="Organizer" />
									</c:when>
									<c:otherwise>
										<c:out value="Member" />
									</c:otherwise>
								</c:choose></td>
							<td><c:out value="${member.teamName.teamName}" /></td>
							<td><c:choose>
									<c:when test="${member.subscriptionStatus == 0}">
										<img src="<c:url value = "resources/image/0.png"/>"
											height=20px width=20px />
									</c:when>
									<c:when test="${member.subscriptionStatus == 1}">
										<img src="<c:url value = "resources/image/1.png"/>"
											height=20px width=20px />
									</c:when>
									<c:otherwise>
										<img src="<c:url value = "resources/image/2.png"/>"
											height=20px width=20px />
									</c:otherwise>
								</c:choose></td>


							<td><a href="editMember?userId=${member.userId}"><input
									type="button" value="Edit" class="btn btn-primary"
									style="width: 100%; color: #fbfcfc" /></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>