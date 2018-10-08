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
<title>Booking</title>
<style type="text/css">
.con {
	margin-top: 60px;
	float: left;
	width: 100%;
	padding: 10px;
}

#bookingTable {
	border: 4px solid #34495e;
	width: 100%;
}

#addBookingTable {
	border: 4px solid #34495e;
	width: 40%;
	margin-left: auto;
	margin-right: auto;
}

#addBookingTable input {
	width: 100%;
}

#addBookingTable select {
	width: 100%;
}

#editTable {
	width: 40%;
	margin-left: auto;
	margin-right: auto;
}
</style>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>
	<c:if test="${sessionScope.department == 'Administrator'}">
		<%@include file="navBar.jsp"%>
	</c:if>
	<div class="con">
		<c:if test="${sessionScope.post=='1'}">
			<c:if
				test="${sessionScope.department == 'Center Manager' || sessionScope.department == 'Head Manager' || sessionScope.department == 'Administrator'}">
				<c:if test="${sessionScope.department == 'Head Manager' || sessionScope.department == 'Administrator'}">
					<table class="table table-striped" id="bookingTable">
						<tr>
							<td colspan=7
								style="color: #FBFCFC; font-weight: bold; text-align: center; background: #34495e;">Companies
								Weekly Booking Report</td>
						</tr>
						<tr>
							<th>Branch Id</th>
							<th>Week</th>
							<th>Booking count</th>
							<th>Total Income</th>
						</tr>
						<tr>
							<td>b1</td>
							<td>1</td>
							<td>23</td>
							<td>23000</td>
						</tr>

						<tr>
							<td>b2</td>
							<td>1</td>
							<td>25</td>
							<td>25000</td>
						</tr>

						<tr>
							<td>b3</td>
							<td>1</td>
							<td>13</td>
							<td>13000</td>
						</tr>

						<tr>
							<td>b1</td>
							<td>2</td>
							<td>20</td>
							<td>20000</td>
						</tr>

						<tr>
							<td>b2</td>
							<td>2</td>
							<td>32</td>
							<td>32000</td>
						</tr>

						<tr>
							<td>b3</td>
							<td>3</td>
							<td>11</td>
							<td>11000</td>
						</tr>

						<tr>
							<td>b1</td>
							<td>3</td>
							<td>21</td>
							<td>21000</td>
						</tr>

						<tr>
							<td>b2</td>
							<td>3</td>
							<td>14</td>
							<td>14000</td>
						</tr>

						<tr>
							<td>b3</td>
							<td>3</td>
							<td>15</td>
							<td>15000</td>
						</tr>

					</table>
				</c:if>

				<table class="table table-striped" id="bookingTable">
					<tr>
						<td colspan=7
							style="color: #FBFCFC; font-weight: bold; text-align: center; background: #34495e;">Branch
							${staff.departmentId.branchId.branchId} Daily Booking Report</td>
					</tr>
					<tr>
						<th>Booking Date</th>
						<th>Pitch No</th>
						<th>Branch Id</th>
						<th>Branch City</th>
						<th>Branch Street</th>
						<th>Team Organizer</th>
					</tr>
					<tr>
						<td>2018/04/1</td>
						<td>1</td>
						<td>${staff.departmentId.branchId.branchId}</td>
						<td>London</td>
						<td>MB-10</td>
						<td>Anu</td>
					</tr>
					<tr>
						<td>2018/04/1</td>
						<td>2</td>
						<td>${staff.departmentId.branchId.branchId}</td>
						<td>London</td>
						<td>MB-11</td>
						<td>Binit</td>
					</tr>

					<tr>
						<td>2018/04/2</td>
						<td>3</td>
						<td>${staff.departmentId.branchId.branchId}</td>
						<td>London</td>
						<td>MB-1</td>
						<td>Pradeep</td>
					</tr>

					<tr>
						<td>2018/04/2</td>
						<td>2</td>
						<td>${staff.departmentId.branchId.branchId}</td>
						<td>London</td>
						<td>MB-50</td>
						<td>Soyam</td>
					</tr>

					<tr>
						<td>2018/04/4</td>
						<td>3</td>
						<td>${staff.departmentId.branchId.branchId}</td>
						<td>London</td>
						<td>MB-10</td>
						<td>Akasg</td>
					</tr>

					<tr>
						<td>2018/04/6</td>
						<td>4</td>
						<td>${staff.departmentId.branchId.branchId}</td>
						<td>London</td>
						<td>MB-11</td>
						<td>Binit</td>
					</tr>

					<tr>
						<td>2018/04/1</td>
						<td>2</td>
						<td>${staff.departmentId.branchId.branchId}</td>
						<td>London</td>
						<td>MB-11</td>
						<td>Binit</td>
					</tr>

					<tr>
						<td>2018/04/1</td>
						<td>2</td>
						<td>${staff.departmentId.branchId.branchId}</td>
						<td>London</td>
						<td>MB-11</td>
						<td>Binit</td>
					</tr>
				</table>
			</c:if>
		</c:if>

		<c:if test="${sessionScope.post=='0'}">
			<table class="table table-striped" id="addBookingTable">
				<tr>
					<th><Strong>Member Id: </Strong></th>
					<td>${booking.teamName.teamName}</td>
					<th><strong>Branch Id: </strong></th>
					<td>${booking.branchId.branchId}</td>
				</tr>
			</table>

			<form:form action="/FootBallProject/addBooking" method="POST"
				commandName="booking">
				<table class="table table-striped" id="addBookingTable">

					<tr>
						<th><Strong><form:label path="pitchNo">PitchNo: </form:label></Strong></th>
						<td><form:select path="pitchNo">
								<option value='1'>1</option>
								<option value='2'>2</option>
								<option value='3'>3</option>
								<option value='4'>4</option>
							</form:select>
					</tr>

					<tr>
						<th><Strong><form:label path="date">Booking Date: </form:label></Strong></th>
						<td><form:input path="date" /></td>
					</tr>
					<tr>
						<th><Strong><form:label path="bookingTime">Time: </form:label></Strong></th>
						<td><form:select path="bookingTime">
								<option value='8-9'>8-9</option>
								<option value='9-10'>9-10</option>
								<option value='10-11'>10-11</option>
								<option value='11-12'>11-12</option>
								<option value='12-13'>12-13</option>
								<option value='13-14'>13-14</option>
								<option value='14-15'>14-15</option>
								<option value='15-16'>15-16</option>
								<option value='16-17'>16-17</option>
							</form:select></td>
					</tr>
					<tr>
						<td colspan=2>
					<tr>
						<td colspan=2><input type="submit" value="Done"
							class="btn btn-success" style="width: 100%" /></td>
				</table>
			</form:form>
		</c:if>


		<table class="table table-striped" id="bookingTable">
			<tr>
				<td colspan=7
					style="color: #FBFCFC; font-weight: bold; text-align: center; background: #34495e;">Bookings
					List</td>
			</tr>
			<tr>
				<th>Booking Date</th>
				<th>Pitch No</th>
				<th>Branch Id</th>
				<th>Branch City</th>
				<th>Branch Street</th>
				<th>Team Name</th>
			</tr>
			<c:forEach items="${bookingList}" var="booking">
				<tr>
					<td><fmt:formatDate value="${booking.date}"
							pattern="dd-MM-yyyy" /></td>
					<td><c:out value="${booking.pitchNo}" /></td>
					<td><c:out value="${booking.branchId.branchId}" /></td>
					<td><c:out value="${booking.branchId.branchCity}" /></td>
					<td><c:out value="${booking.branchId.branchStreet}" /></td>
					<td><c:out value="${booking.teamName.teamName}" /></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${!empty monthlyBookings}">
			<table class="table table-striped" id="bookingTable">
				<tr>
					<td colspan=7
						style="color: #FBFCFC; font-weight: bold; text-align: center; background: #34495e;">Monthly
						Bookings ${booking.branchId.branchId}</td>
				</tr>
				<tr>
					<th>Booking Date</th>
					<th>Pitch No</th>
					<th>Branch Id</th>
					<th>Branch City</th>
					<th>Branch Street</th>
					<th>Team Name</th>
				</tr>
				<c:forEach items="${monthlyBookings}" var="booking">
					<tr>
						<td><fmt:formatDate value="${booking.date}"
								pattern="dd-MM-yyyy" /></td>
						<td><c:out value="${booking.pitchNo}" /></td>
						<td><c:out value="${booking.branchId.branchId}" /></td>
						<td><c:out value="${booking.branchId.branchCity}" /></td>
						<td><c:out value="${booking.branchId.branchStreet}" /></td>
						<td><c:out value="${booking.teamName.teamName}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>