<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spedycja-pojazdy</title>
</head>
<body>
<table class="table table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Marka</th>
			<th>Model</th>
			<th>Pojemnosc</th>
			<th>Status podjecia</th>
		</tr>
	</thead>
	<c:forEach var="car" items="${cars}">
		<tr>
			<td>${car.id}</td>
			<td>${car.marka}</td>
			<td>${car.model}</td>
			<td>${car.pojemnosc}</td>
			<td>${car.status}</td>
			<td>
			
				<button class="btn btn-primary" onclick="location.href='car/${car.id}/update'">Edytuj</button>
				<button class="btn btn-danger" onclick="this.disabled=true;post('car/${car.id}/delete')">Usun</button>
				<security:authorize access="hasRole('ROLE_DRIVER')" url="/**">
					<button class="btn btn-primary" onclick="location.href='car/${car.id}/take'">Podejmij auto</button>
					<button class="btn btn-primary" onclick="location.href='car/${car.id}/return'">Zwolnij auto</button>
				</security:authorize>
			</td>
		</tr>
	</c:forEach>


</table>
<button class="btn btn-primary" onclick="location.href='car/add'">Dodaj auto</button>
<button class="btn btn-primary" onclick="location.href='/wi/'">Powrot do strony glownej</button>
</body>
</html>