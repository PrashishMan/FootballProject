<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/css/menuStyle.css" />">
<style>
nav {
	float: left;
}

nav ul {
	display: block;
	float: right;
}

nav li {
	float: right;
	padding: 10px;
	color: #FBFCFC;
}

nav li a {
	color: #FBFCFC;
}

nav li a:hover {
	color: #FDFEFE;
	text-decoration: none;
}
</style>

<nav>

	<ul>
		<li><a href="/FootBallProject/"><Strong>Home</Strong></a></li>
		<c:if test="${sessionScope.department == 'Administrator'}">
			<li><a href="/FootBallProject/subscriptionPage"><strong>Subscription</strong></a></li>
		</c:if>
		<c:if test="${sessionScope.department == 'Administrator'}">
			<li><a href="/FootBallProject/bookingPage"><strong>Booking</strong></a></li>
		</c:if>

		<li><a href="/FootBallProject/logout"><strong>Logout</strong></a></li>
	</ul>

</nav>