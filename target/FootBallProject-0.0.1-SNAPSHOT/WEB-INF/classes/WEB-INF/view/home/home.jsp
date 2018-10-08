<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/homeStyle.css" />">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<div class="title">
		<span class="pageHeading">Home</span> <a
			href="/FootBallProject/logout"><input type="button"
			name="search" value="logout" class="btn btn-danger"
			style="float: right; margin: 7px 10px" /></a>
	</div>
	<div class="pageTitle">
		<img src=<c:url value = "/resources/image/sockerBall.png" />
			alt="sockerball" class="sockerBall" /> <span>Five Side
			Football</span>
	</div>
	<c:choose>
		<c:when test="${!empty headBranch.branchId}">
			<div class="branchInfo">
				<H3>Head Office</H3>
				<H4>Po Box: ${headBranch.poBox} Fax: ${headBranch.faxNo}</H4>
				<H4>tel: ${headBranch.telephoneNo}</H4>
				<H4>${headBranch.branchCity}, ${headBranch.branchStreet}</H4>
			</div>

			<c:choose>
				<c:when test="${sessionScope.post == '1'}">
					<c:choose>
						<c:when test="${sessionScope.department == 'Administrator'}">
							<%@include file="staffHomePage.jsp"%>
						</c:when>
						
						<c:when test="${sessionScope.department == 'Accounts'}">
							<%@include file="staffHomePage.jsp"%>
						</c:when>
						
						<c:when test="${sessionScope.department == 'Secretary'}">
							<%@include file="staffHomePage.jsp"%>
						</c:when>
						
						<c:when test="${sessionScope.department == 'Center Manager'}">
							<%@include file="staffHomePage.jsp"%>
						</c:when>
						
						<c:when test="${sessionScope.department == 'Head Manager'}">
							<%@include file="staffHomePage.jsp"%>
						</c:when>
						
						<c:when test="${sessionScope.department == 'Rececptionist'}">
							<%@include file="../membersPage.jsp"%>
						</c:when>					
						
						
					</c:choose>
				</c:when>
				<c:otherwise>
					<%@include file="memberHomePage.jsp"%>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<%@include file="createHeadBranch.jsp"%>

		</c:otherwise>
	</c:choose>
</body>
</html>