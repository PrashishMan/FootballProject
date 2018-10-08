<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
.branchContainer {
	margin-top: 100px;
	width: 100%;
}

#createHeadForm {
	width: 50%;
	border: 2px solid #34495E;
	margin-left: auto;
	margin-right: auto;
}

</style>
</head>
<body>
	<div class="branchContainer">
		<form:form action="createHeadBranch" method="post"
			commandName="headBranch">
			<table class="table table-hover" id="createHeadForm">
				<tr>
					<td colspan=7
						style="color: #FBFCFC; font-weight: bold; text-align: center; background: #34495e;">Create Head Branch</td>
				</tr>
				<tr>
					<td><form:label path="branchId">Branch ID :</form:label></td>
					<td><form:input path="branchId"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="branchCity">City :</form:label></td>
					<td><form:input path="branchCity"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="branchStreet">Street :</form:label></td>
					<td><form:input path="branchStreet"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="faxNo">Fax No :</form:label></td>
					<td><form:input path="faxNo"></form:input></td>
				</tr>

				<tr>
					<td><form:label path="poBox">Po Box :</form:label></td>
					<td><form:input path="poBox"></form:input></td>
				</tr>

				<tr>
					<td><form:label path="telephoneNo">Telephone No :</form:label>
					</td>
					<td><form:input path="telephoneNo"></form:input></td>
				</tr>

				<tr>
					<td colspan=2><input type="submit" class="btn btn-default"
						style="width: 100%; margin-top: 10px" value="Done"></input></td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>
