<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department</title>
<style>
#departmentInsertTable {
	border: 4px solid #2E4053;
	width: 40%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
}

#departmentInsertTable input, select {
	width: 100%;
}

#departmentView {
	border: 4px solid #2E4053;
	width: 90%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
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
	<form:form action="/FootBallProject/addDepartment" method="POST" commandName = "department">
		<table class="table table-striped" id="departmentInsertTable">
			<tr>
				<td colspan=2
					style="text-align: center; font-weight: bold; background: #34495e; color: #FBFCFC;">
					Department</td>
			</tr>

			<tr>
				<th><Strong><form:label path="departmentId">DepartmentId: </form:label></Strong></th>
				<td><form:input path="departmentId"
						value="${department.departmentId}" /></td>
			</tr>
			<tr>
				<th><Strong><form:label path="departmentName">DepartmentName: </form:label></Strong></th>

				<td><form:input path="departmentName"
						value="${department.departmentName}" /></td>
			</tr>
			<tr>
				<th><Strong><form:label path="branchId.branchId">Branch: </form:label></Strong></th>
				<td><form:select path="branchId.branchId">
						<option value=""></option>
						<c:forEach items="${branches}" var="branch">

							<c:choose>
								<c:when
									test="${branch.branchId == department.branchId.branchId }">
									<option value="${branch.branchId}" selected>${branch.branchId}</option>
								</c:when>
								<c:otherwise>
									<option value="${branch.branchId}">${branch.branchId}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>



			<tr>
				<td colspan=2><input type="submit" value="Done"
					class="btn btn-primary" style="width: 100%; color: #fbfcfc" /></td>

			</tr>
		</table>
	</form:form>
	<table class="table table-striped" id="departmentView">
		<tr>
			<td colspan=4
				style="text-align: center; font-weight: bold; background: #34495e; color: #FBFCFC;">
				Department Table</td>
		</tr>
		<tr>
			<th>DepartmentId</th>
			<th>Branch</th>
			<th>Department Name</th>
			<th>Update</th>
		</tr>

		<c:forEach items="${departments}" var="department">
			<tr>
				<td><c:out value="${department.departmentId}" /></td>
				<td><c:out value="${department.branchId.branchId}" /></td>
				<td><c:out value="${department.departmentName}" /></td>
				<td><a
					href="<c:out value = "editDepartment?departmentId=${department.departmentId}"/>"><input
						type="button" value="Edit" class="btn btn-primary" /></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>