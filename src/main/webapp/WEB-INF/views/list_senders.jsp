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
	Nadawcy:
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
	<c:forEach var="sender" items="${senders}">
		<tr>
			<td>${sender.id}</td>
			<td>${sender.name}</td>
			<td>${sender.street}</td>
			<td>${sender.number}</td>
			<td>${sender.city}</td>
			<td>${sender.state}</td>
			<td>${sender.zipCode}</td>
			<td>
			
				<button class="btn btn-primary" onclick="location.href='/sender/${sender.id}/update'">Edytuj</button>
				<button class="btn btn-danger" onclick="this.disabled=true;post('/sender/${sender.id}/delete')">Usun</button>
			</td>
		</tr>
	</c:forEach>


</table>



</body>
</html>