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
	<a href ="spring_security_login">Zaloguj</a></br>
<security:authorize access="hasRole('ROLE_USER')">
	</br>
	<a href ="senders">Zobacz nadawcow</a>
	</br>

	<a href ="receivers">Zobacz odbiorcow</a>
	
	</br>
	<a href ="cars">Zobacz pojazdy</a>
</security:authorize>
</br>
<security:authorize access="hasRole('ROLE_DRIVER')" url="/**">
	<a href ="car/take">Podejmij lub zwroc auto</a>
</security:authorize>
</body>
</html>
