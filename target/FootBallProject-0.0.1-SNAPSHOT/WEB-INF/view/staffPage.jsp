<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff</title>
<style>
#staffInsertTable {
	border: 4px solid #2E4053;
	width: 40%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
}

#staffInsertTable input, select {
	width: 100%;
}

.title {
	background-color: #5D6D7E;
	text-align: center;
	color: #F7F9F9;
	font-size: 20px;
	font-weight: bold;
	display: block;
	height: 100px;
	margin-bottom: 20px;
}
</style>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>
	<div class="title">
		<%@include file="navBar.jsp"%>
	</div>
	<form:form action="/FootBallProject/registerStaff" method="POST">
		<table class="table table-striped" id="staffInsertTable">
			<form:input path="userId" readonly="true" type="hidden" />
			<tr>
				<td colspan=2
					style="text-align: center; font-weight: bold; background: #34495e; color: #FBFCFC;">Add
					Staff</td>
			</tr>


			<tr>
				<th><Strong><form:label path="password">Password: </form:label></Strong></th>
				<td><form:input path="password" value="${staff.password}" />
			</tr>

			<tr>
				<th><Strong><form:label path="firstName">First Name: </form:label></Strong></th>
				<td><form:input path="firstName" value="${staff.firstName}" />
			</tr>
			<tr>
				<th><Strong><form:label path="lastName">Last Name: </form:label></Strong></th>
				<td><form:input path="lastName" value="${staff.lastName}" />
			</tr>

			<tr>
				<th><Strong><form:label path="city">City: </form:label></Strong></th>
				<td><form:input path="city" value="${staff.city}" />
			</tr>
			<tr>
				<th><Strong><form:label path="street">Street: </form:label></Strong></th>
				<td><form:input path="street" value="${staff.street}" /></td>
			</tr>


			<tr>
				<th><Strong><form:label path="gender">Gender: </form:label></Strong></th>
				<td><form:select path="gender">

						<c:choose>
							<c:when test="${staff.gender == 'Male'}">
								<option value="Male" selected>Male</option>
								<option value="Female">Female</option>
							</c:when>
							<c:when test="${staff.gender == 'Female'}">
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
				<td><fmt:formatDate value="${staff.dateOfBirth}"
						pattern="yyyy/MM/dd" var="DOB" /> <form:input type="text"
						path="dateOfBirth" value="${DOB}" /></td>
			</tr>

			<tr>
				<th><Strong><form:label path="hireDate">Hiredate: </form:label></Strong></th>
				<td><fmt:formatDate value="${staff.hireDate}"
						pattern="yyyy/MM/dd" var="hireDate" /> <form:input type="text"
						path="hireDate" value="${hireDate}" /></td>
			</tr>

			<tr>
				<th><Strong><form:label path="salary">Salary: </form:label></Strong></th>
				<td><form:input path="salary" value="${staff.salary}" /></td>
			</tr>


			<tr>
				<th><Strong><form:label
							path="departmentId.departmentId">Department: </form:label></Strong></th>
				<td><c:if test="${!empty departments }">
						<form:select path="departmentId.departmentId">
							<option value=""></option>
							<c:forEach items="${departments}" var="department">

								<c:choose>
									<c:when
										test="${department.departmentId == staff.departmentId.departmentId }">
										<option value="${department.departmentId}" selected>${department.departmentId}</option>
									</c:when>
									<c:otherwise>
										<option value="${department.departmentId}">${department.departmentId}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</c:if></td>
			</tr>

			<tr>
				<td colspan=2><input type="submit" value="Done"
					class="btn btn-primary" style="width: 100%; color: #fbfcfc" /></td>

			</tr>

		</table>

		<table class="table table-striped">

			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>City</th>
				<th>Street</th>
				<th>Gender</th>
				<th>Date Of Birth</th>
				<th>HireDate</th>
				<th>Salary</th>
				<th>DepartmentId</th>
				<th>Edit</th>

			</tr>

			<c:forEach items="${staffList}" var="staff">
				<tr>
					<td><c:out value="${staff.userId}" /></td>
					<td><c:out value="${staff.password}" /></td>
					<td><c:out value="${staff.firstName}" /></td>
					<td><c:out value="${staff.lastName}" /></td>
					<td><c:out value="${staff.city}" /></td>
					<td><c:out value="${staff.street}" /></td>
					<td><c:out value="${staff.gender}" /></td>
					<td><fmt:formatDate value="${staff.dateOfBirth}"
							pattern="yy/MM/dd" /></td>
					<td><fmt:formatDate value="${staff.hireDate}"
							pattern="yy/MM/dd" /></td>
					<td><c:out value="${staff.salary}" /></td>
					<td><c:out value="${staff.departmentId.departmentId}" /></td>
					<td><a
						href="<c:out value = "editStaff?userId=${staff.userId}"/>"><input
							type="button" value="Edit" class="btn btn-primary" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>