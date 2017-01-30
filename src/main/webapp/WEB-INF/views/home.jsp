<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spedycja</title>
</head>
<body>
<h1>
	Witaj na stronie glownej! 
</h1>

<P>  Aktualny czas to ${serverTime}. </P>
<security:authorize access="hasRole('ROLE_USER')">
	<a href ="/sender/add">Dodaj nadawce</a>
</security:authorize>
</body>
</html>
