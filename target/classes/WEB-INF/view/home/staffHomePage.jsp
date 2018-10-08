<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="Container">
	<div class="content">
		<div class="imageContainer">
			<img src=<c:url value = "/resources/image/member.png"/> width="100%"
				height="100%" />
		</div>
		<div class="infoContainer">
			<div class=infoTitle>MEMBERS</div>
			<table class="table table-striped">
				<tr>
					<td><span class="infoLabel"> Member: </span></td>
					<td>${pageContent.memberCount}</td>
				</tr>

				<tr>
					<td><span class="infoLabel"> Team: </span></td>
					<td>${pageContent.teamCount}</td>
				</tr>

				<tr>
					<td colspan="2"><span class="infoLabel"> Description: </span>
					</td>
				</tr>
				<tr>
					<td colspan="2"><textarea readOnly rows="3" cols="34"
							style="border-radius: 10px; margin: 0; padding: 2px; text-align: center"
							placeholder="this text will show in the this text will show in the this text will show in the "></textarea>
					</td>
				</tr>
			</table>
		</div>
		<a href=<c:url value = "membersPage"/>><input type="button"
			class="btn btn-primary"
			style="margin-left: 2%; width: 96%; border-radius: 20px"
			value="View Members"></input></a>
	</div>

	<c:if test="${sessionScope.department == 'Administrator'}">
		<div class="content">
			<div class="imageContainer">
				<img src=<c:url value = "/resources/image/branchOffice.png"/>
					width="100%" height="100%" />
			</div>
			<div class="infoContainer">
				<div class=infoTitle>BRANCH OFFICE</div>
				<table class="table table-striped">
					<tr>
						<td><span class="infoLabel"> Branch: </span></td>
						<td>${pageContent.branchCount}</td>
					</tr>

					<tr>
						<td><span class="infoLabel"> Departments: </span></td>
						<td>${pageContent.departmentCount}</td>
					</tr>

					<tr>
						<td colspan="2"><span class="infoLabel"> Description:
						</span></td>
					</tr>
					<tr>
						<td colspan="2"><textarea readOnly rows="3" cols="34"
								style="border-radius: 10px; margin: 0; padding: 2px; text-align: center"
								placeholder="this text will show in the this text will show in the this text will show in the "></textarea>
						</td>
					</tr>
				</table>
			</div>
			<a href=<c:url value = "branchPage" />><input type="button"
				class="btn btn-primary"
				style="margin-left: 2%; width: 96%; border-radius: 20px"
				value="Done"></input></a>
		</div>
	</c:if>

	<c:if test="${sessionScope.department != 'Rececptionist' && sessionScope.department != 'Accounts'}">
		<div class="content">
			<div class="imageContainer">
				<img src=<c:url value = "/resources/image/booking.png"/>
					width="100%" height="100%" />
			</div>
			<div class="infoContainer">
				<div class=infoTitle>BOOKINGS</div>
				<table class="table table-striped">
					<tr>
						<td><span class="infoLabel"> Bookings: </span></td>
						<td>${pageContent.bookingCount}</td>
					</tr>

					<tr>
						<td><span class="infoLabel"> Booked: </span></td>
						<td>${pageContent.bookedCount}</td>
					</tr>

					<tr>
						<td colspan="2"><span class="infoLabel"> Description:
						</span></td>
					</tr>
					<tr>
						<td colspan="2"><textarea readOnly rows="3" cols="34"
								style="border-radius: 10px; margin: 0; padding: 2px; text-align: center"
								placeholder="this text will show in the this text will show in the this text will show in the "></textarea>
						</td>
					</tr>
				</table>
			</div>
			<a href="<c:url value = "bookingPage" />"> <input type="button"
				class="btn btn-primary"
				style="margin-left: 2%; width: 96%; border-radius: 20px"
				value="Done"></a></input>
		</div>
	</c:if>

	<c:if
		test="${sessionScope.department == 'Administrator' || sessionScope.department == 'Accounts'}">
		<div class="content">
			<div class="imageContainer">
				<img src=<c:url value = "/resources/image/subscription.jpg"/>
					width="100%" height="100%" />
			</div>
			<div class="infoContainer">
				<div class=infoTitle>SUBSCRIPTION</div>
				<table class="table table-striped">
					<tr>
						<td><span class="infoLabel"> Junior Subs: </span></td>
						<td>${pageContent.juniorSubs}</td>
					</tr>

					<tr>
						<td><span class="infoLabel"> Senior Subs: </span></td>
						<td>${pageContent.seniorSubs}</td>
					</tr>

					<tr>
						<td colspan="2"><span class="infoLabel"> Description:
						</span></td>
					</tr>
					<tr>
						<td colspan="2"><textarea readOnly rows="3" cols="34"
								style="border-radius: 10px; margin: 0; padding: 2px; text-align: center"
								placeholder="this text will show in the this text will show in the this text will show in the "></textarea>
						</td>
					</tr>
				</table>
			</div>
			<a href=<c:url value ="subscriptionPage"/>><input type="button"
				class="btn btn-primary"
				style="margin-left: 2%; width: 96%; border-radius: 20px"
				value="View Subscription"></input></a>
		</div>
		<c:if
			test="${sessionScope.department == 'Administrator'}">
		<div class="content">
			<div class="imageContainer">
				<img src=<c:url value = "/resources/image/staff.jpg"/> width="100%"
					height="100%" />
			</div>
			<div class="infoContainer">
				<div class=infoTitle>Employees</div>
				<table class="table table-striped">
					<tr>
						<td><span class="infoLabel"> Employee Count: </span></td>
						<td>${pageContent.staffCount}</td>
					</tr>

					<tr>
						<td colspan="2"><span class="infoLabel"> Description:
						</span></td>
					</tr>
					<tr>
						<td colspan="2"><textarea readOnly rows="5" cols="34"
								style="border-radius: 10px; margin: 0; padding: 2px; text-align: center"
								placeholder="this text will show in the this text will show in the this text will show in the "></textarea>
						</td>
					</tr>
				</table>
			</div>
			<a href=<c:url value ="staffPage"/>><input type="button"
				class="btn btn-primary"
				style="margin-left: 2%; width: 96%; border-radius: 20px"
				value="View Subscription"></input></a>
</div>

<div class="content">
	<div class="imageContainer">
		<img src=<c:url value = "/resources/image/departments.png"/>
			width="100%" height="100%" />
	</div>
	<div class="infoContainer">
		<div class=infoTitle>Departments</div>
		<table class="table table-striped">
			<tr>
				<td><span class="infoLabel"> Departments count: </span></td>
				<td>${pageContent.departmentCount}</td>
			</tr>

			<tr>
				<td colspan="2"><span class="infoLabel"> Description: </span></td>
			</tr>
			<tr>
				<td colspan="2"><textarea readOnly rows="5" cols="34"
						style="border-radius: 10px; margin: 0; padding: 2px; text-align: center"
						placeholder="this text will show in the this text will show in the this text will show in the "></textarea>
				</td>
			</tr>
		</table>
	</div>
	<a href=<c:url value ="departmentPage"/>><input type="button"
		class="btn btn-primary"
		style="margin-left: 2%; width: 96%; border-radius: 20px"
		value="View Subscription"></input></a>
</div>
</c:if>
</c:if>
</div>
