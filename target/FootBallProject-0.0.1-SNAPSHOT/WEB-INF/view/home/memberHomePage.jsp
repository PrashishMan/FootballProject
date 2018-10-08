<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<style type="text/css">
#memberTable, #bookingTable {
	border: 2px solid #34495e;
	width: 50%;
	margin-left: auto;
	margin-right: auto;
}

#bookingTable {
	width: 90%;
}

.errorMessage {
	display: block;
	background: #ec7063;
	color: #FBFCFCFC;
	font-size: 18px;
	padding: 10px;
	text-align: center;
}

#teamSelectTable select {
	width: 100%;
}

.centerDiv {
	width: 45%;
	margin-left: 20px;
	height: 175px;
	background-color: #cacfd2;
	border-radius: 10px 10px 0 0;
	align: center;
	margin-bottom: 10px;
	float: left;
}

.centerTitle {
	text-align: center;
	display: block;
	background: #f0f3f4;
	padding: 10px;
	border-radius: 10px 10px 0 0;
	margin-bottom: 5px;
}

.certerImg {
	height: 125px;
	width: 23.8%;
	float: left;
	display: inline;
	margin-left: 10px;
}

#teamSelectTable {
	background: #F4F7F6;
	color: #34495e;
	width: 400px;
	margin-left: auto;
	margin-right: auto;
}

.teamSelect {
	height: 100px;
	font-size: 14px;
	font-weight: bold;
	display: block;
	
}

.titleSpan{
	background:  #34495e ;
	display: block;
	padding: 10px;
	color: #DCDCCD;
	text-align: center;
}


</style>
</head>
<body>
	<c:if test="${!empty errorMessage}">
		<span class="errorMessage">${errorMessage}</span>
	</c:if>
	<table class="table table-striped" id="memberTable">
		<tr>
			<td colspan=2
				style="padding: 10px; text-align: center; background: #34495e; color: #FBFCFC"><strong>Member
					Information</strong></td>
		</tr>
		<tr>
			<th><Strong>First Name:</Strong></th>
			<td>${member.firstName}</td>
		</tr>

		<tr>
			<th><Strong>Last Name:</Strong></th>
			<td>${member.lastName}</td>
		</tr>

		<tr>
			<th><Strong>Date Of Birth: </Strong></th>
			<td>${member.dateOfBirth}</td>
		</tr>

		<tr>
			<th><Strong>Gender:</Strong></th>
			<td>${member.gender}</td>
		</tr>

		<tr>
			<th><Strong>Email</Strong></th>
			<td>${member.email}</td>
		</tr>

		<tr>
			<th><Strong>City:</Strong></th>
			<td>${member.city}</td>
		</tr>

		<tr>
			<th><Strong>Street: </Strong></th>
			<td>${member.street}</td>
		</tr>
		<tr>
			<th><Strong>MemberShipType:</Strong></th>
			<td>${member.memberShipType}</td>
		</tr>
		<tr>
			<th><Strong>Team Name: </Strong></th>
			<td>${member.teamName.teamName}</td>
		</tr>

	</table>

	<c:choose>
		<c:when test="${empty member.teamName}">
			<c:choose>
				<c:when test="${member.isOrganizer}">
					<div class="teamSelect">
						<form:form action="createTeam" method="POST" commandName="team">
							<table class="table table-striped" id="teamSelectTable"
								style="border: 3px solid  #2e4053 ;">
								<tr>
									<td colspan=3 style="padding: 10px; text-align: center; background-color:  #2e4053 ; color: #FCFCFC;"><strong>Create
											Team</strong></td>
								</tr>
								<tr style="padding: 10px;">
									<td style="padding: 10px;">Team Name</td>
									<td style="padding: 10px;"><form:input path="teamName"
											style="color: #34495e" /></td>
									<td style="padding-top: 5px;"><input
										class="btn btn-success" type="submit" value="Create"
										style="color: #34495e" /></td>
								</tr>
							</table>
						</form:form>
					</div>
				</c:when>
				<c:otherwise>
					<div class="teamSelect">
						<form:form action="createTeam" method="POST" commandName="team">
							<table class="table table-striped" id="teamSelectTable"
								style="border: 3px solid #DCDCDC;">
								<tr>
									<td>Select</td>
									<td><form:select path="teamName">
											<c:forEach items="${teamList}" var="team">
												<option>${team.teamName}</option>
											</c:forEach>

										</form:select></td>
								</tr>
								<tr>
									<td colspan=2><input type="submit" value="Join"
										style="width: 100%" /></td>
								</tr>

							</table>

						</form:form>

					</div>

				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<table class="table table-striped" id="bookingTable">
				<tr>
					<td colspan=7
						style="color: #FBFCFC; font-weight: bold; text-align: center; background: #34495e;">Personal
						Booking Record</td>
				</tr>
				<tr>
					<th>Booking Date</th>
					<th>Booking Time</th>
					<th>Pitch No</th>
					<th>Branch Id</th>
					<th>Branch City</th>
					<th>Branch Street</th>
					<c:if test="${member.isOrganizer }">
						<th>Cancel</th>
					</c:if>
				</tr>
				<c:forEach items="${memberBookings}" var="booking">
					<tr>
						<td><fmt:formatDate type="both" pattern="yyyy-MM-dd"
								value="${booking.date}" /></td>
						<td><c:out value="${booking.bookingTime}" /></td>
						<td><c:out value="${booking.pitchNo}" /></td>
						<td><c:out value="${booking.branchId.branchId}" /></td>
						<td><c:out value="${booking.branchId.branchCity}" /></td>
						<td><c:out value="${booking.branchId.branchStreet}" /></td>
						<c:if test="${member.isOrganizer }">
							<td><a
								href=<c:out value = "removeBooking?bookingId=${booking.bookingId}"/>><input
									type="button" value="Cancel" class="btn btn-danger"
									style="width: 60%;" /></a></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

	<div class="mainDiv">
		<span class="titleSpan"><h1>Football Centers</h1> </span>


		<div class="aa"
			style="width: 100%; float: left; display: block; margin: 10px; border: 4px solid #626567; padding: 20px; border-radius: 6px; background: #2C3E50">
			<c:if test="${!empty branchList}">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${branchList}" var="branchlist">

					<div class="centerDiv"
						style="margin-left: 40px; margin-bottom: 20px;">
						<div class="centerTitle">
							<h5>Branch:</h5>
							<c:out value="${count + 1}" />
							(
							<c:out value="${branchlist.branchId}" />
							)
						</div>
						<img src=<c:url value = "/resources/image/sockerBall.png" />
							alt="sockerball" class="certerImg" />
						<table class="table table-striped"
							style="width: 70%; margin-left: 20px; float: left; background-color: #e5e7e9">
							<tr>
								<td>Location: <c:out value="${branchlist.getBranchCity()}" />,
									<c:out value="${branchlist.getBranchStreet()}" /></td>
								<td>tel : <c:out value="${branchlist.getTelephoneNo()}" /></td>
							</tr>
							<tr>
								<td>Po-Box: <c:out value="${branchlist.getPoBox()}" /></td>
								<td>fax : <c:out value="${branchlist.getFaxNo()}" /></td>
							</tr>
							<tr>
								<td colspan="2"><a
									href=<c:out value = "bookingPage?branchId=${branchlist.branchId}"/>><input
										type="button" value="Book" class="btn btn-success"
										style="width: 30%; float: right" /></a></td>
							</tr>
						</table>
					</div>
					<c:set var="count" value="${count + 1}" scope="page" />
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>

