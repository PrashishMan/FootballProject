<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscription</title>
</head>
<body>
<form:form action="/FootBallProject/registerMember" method="POST"
			commandName="newMember">
			<table class="table table-striped" id="memberInsertTable">
				<tr>
					<th><Strong><form:label path="firstName">First Name: </form:label></Strong></th>
					<td><form:input path="firstName" />
				</tr>
				<tr>
					<th><Strong><form:label path="lastName">Last Name: </form:label></Strong></th>
					<td><form:input path="lastName" />
				</tr>
				<tr>
					<th><Strong><form:label path="city">City: </form:label></Strong></th>
					<td><form:input path="city" />
				</tr>
				<tr>
					<th><Strong><form:label path="street">Street: </form:label></Strong></th>
					<td><form:input path="street" /></td>
				</tr>
				<tr>
					<th><Strong><form:label path="gender">Gender: </form:label></Strong></th>
					<td><form:select path="gender">
							<option value="Male">Male</option>
							<option value="Female">Female</option>
						</form:select></td>
				</tr>
				<tr>
					<th><Strong><form:label path="dateOfBirth">Date Of Birth: </form:label></Strong></th>
					<td><form:input path="dateOfBirth" />
				</tr>
			</table>
		</form:form>
</body>
</html>