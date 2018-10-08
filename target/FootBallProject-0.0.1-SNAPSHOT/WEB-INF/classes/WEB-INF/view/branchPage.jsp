
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Branch Page</title>
<style type="text/css">
.editContainer {
	margin-top: 60px;
	float: left;
	padding: 20px;
	width: 100%;
}

#branchTable, #editTable {
	border: 4px solid #34495e;
}

#editTable {
	width: 40%;
	margin-left: auto;
	margin-right: auto;
}

#editTable input {
	width: 100%;
}

#branchTable input {
	width: 100%;
}
</style>
</head>
<body>
	<%@include file="navBar.jsp"%>


	<div class="editContainer">
		<table class="table table-striped" align="center" id="editTable">
			<form:form action="addBranch" method="post" commandName="branch">
			<form:input path = "isHeadBranch" value = "${isHeadBranch}" hidden = "true"/>
				<tr>
					<td colspan=2
						style="color: #FBFCFC; font-weight: bold; text-align: center; background: #34495e;">

						${empty branch.branchId?"Add Branch":"Edit Branch"}</td>


				</tr>
				<tr>
					<th>Branch Id</th>
					<td><c:choose>
							<c:when test="${empty branch.branchId}">
								<form:input path="branchId" value="${branch.branchId}" />
							</c:when>
							<c:otherwise>
								<form:input path="branchId" value="${branch.branchId}"
									readonly="true" />
							</c:otherwise>
						</c:choose>
						</td>
				</tr>
				<tr>
					<th>Branch City</th>
					<td><form:input type="text" path="branchCity"
							value="${branch.branchCity}" /></td>
				</tr>
				<tr>
					<th>Branch Street</th>
					<td><form:input type="text" path="branchStreet"
							value="${branch.branchStreet}" /></td>
					<tr>
					<th>Po Box</th>
					<td><form:input type="text" path="poBox"
							value="${branch.poBox}" /></td>
				</tr>

				<tr>
					<th>Telephone no</th>
					<td><form:input type="text" path="telephoneNo"
							value="${branch.telephoneNo}" /></td>
				</tr>

				<tr>
					<th>Fax no</th>
					<td><form:input type="text" path="faxNo"
							value="${branch.faxNo}" /></td>
				</tr>

				<tr>
					<td colspan=2>${!empty branch.branchId ? "<input type='submit' value='Edit' class='btn btn-primary' style = 'width: 100%'/>" : 
					"<input type='submit' value='Add' class='btn btn-primary' style = 'width: 100%'/>"}</form:form>
		</table>
		
		<table class="table table-striped" align="center" id="branchTable">
			<tr>
				<td colspan=7
					style="color: #FBFCFC; font-weight: bold; text-align: center; background: #34495e;">Branches</td>
			</tr>
			<tr>
				<th>Branch Id</th>
				<th>Branch City</th>
				<th>Branch Street</th>
				<th>Po Box</th>
				<th>Telephone No</th>
				<th>Fax No</th>
				<th>Edit</th>
			</tr>
			<c:forEach items="${branches}" var="branches">
				<tr>
					<td><c:out value="${branches.branchId}" /></td>
					<td><c:out value="${branches.branchCity}" /></td>
					<td><c:out value="${branches.branchStreet}" /></td>
					<td><c:out value="${branches.poBox}" /></td>
					<td><c:out value="${branches.telephoneNo}" /></td>
					<td><c:out value="${branches.faxNo}" /></td>
					<td><a
						href="<c:out value = "editBranch?branchId=${branches.branchId}"/>"><input
							type="button" value="Edit" class="btn btn-primary"/></a></td>

				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>