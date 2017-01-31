<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<th>Status wypozyczenia</th>
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
			
				<button class="btn btn-primary" onclick="location.href='/car/${car.id}/update'">Edytuj</button>
				<button class="btn btn-danger" onclick="this.disabled=true;post('/car/${car.id}/delete')">Usun</button>
			</td>
		</tr>
	</c:forEach>


</table>
</body>
</html>