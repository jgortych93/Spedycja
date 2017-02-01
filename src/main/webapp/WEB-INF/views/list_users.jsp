<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spedycja - konta uzykownikow</title>
</head>
<body>
<table class="table table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nazwa</th>
			<th>Haslo</th>
			<th>Uprawnienia</th>
		</tr>
	</thead>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.user_role}</td>
			<td>
			
				<security:authorize access="hasRole('ROLE_ADMIN')" url="/**">
					<button class="btn btn-primary" onclick="location.href='user/${user.id}/update'">Edytuj</button>
					<button class="btn btn-primary" onclick="location.href='user/${user.id}/delete'">Usun</button>
				</security:authorize>
			</td>
		</tr>
	</c:forEach>


</table>
<security:authorize access="hasRole('ROLE_ADMIN')" url="/**">
	<button class="btn btn-primary" onclick="location.href='user/add'">Dodaj uzykownika</button>
</security:authorize>
<button class="btn btn-primary" onclick="location.href='/wi/'">Powrot do strony glownej</button>
</body>
</html>