<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Spedycja</title>
</head>
<body>
<h1>
	Odbiorcy:
</h1>

<table class="table table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nazwa</th>
			<th>Ulica</th>
			<th>Numer</th>
			<th>Miasto</th>
			<th>Panstwo</th>
			<th>Kod pocztowy</th>
			<th>Opcje</th>
			
		</tr>
	</thead>
	<c:forEach var="receiver" items="${receivers}">
		<tr>
			<td>${receiver.id}</td>
			<td>${receiver.name}</td>
			<td>${receiver.street}</td>
			<td>${receiver.number}</td>
			<td>${receiver.city}</td>
			<td>${receiver.state}</td>
			<td>${receiver.zipCode}</td>
			<td>
			
				<button class="btn btn-primary" onclick="location.href='receiver/${receiver.id}/update'">Edytuj</button>
				<button class="btn btn-primary" onclick="location.href='receiver/${receiver.id}/delete'">Usun</button>
			</td>
		</tr>
	</c:forEach>


</table>

<button class="btn btn-primary" onclick="location.href='receiver/add'">Dodaj odbiorce</button>

</body>
</html>