<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spedycja-dodawanie uzytkownika</title>
</head>
<body>
<h1>
	<c:choose>
<c:when test="${userForm['id']==null}">
	Dodaj uzytkownika:
</c:when>
<c:otherwise>
	Edytuj uzykownika:
</c:otherwise>
</c:choose>
</h1>

<form:form  modelAttribute="userForm" method="POST">

 Login: 
 <form:input path="username" id="username"></form:input>
 <form:errors path="username"/>

 <br />

 Haslo: 
 <form:input path="password" id="password"></form:input>
 <form:errors path="password"/>
 <br />

Uprawnienia:
 <form:select path="user_role" id="user_role">
 	<form:option value="ROLE_USER"></form:option>
 	<form:option value="ROLE_DRIVER"></form:option>
 	<form:option value="ROLE_ADMIN"></form:option>
 	<form:option value="ROLE_MANAGER"></form:option>
 </form:select>


 <br />

 

<security:authorize access="hasRole('ROLE_ADMIN')" url="/**">
 <input type="submit" value="Dodaj uzytkownika" />
</security:authorize>

</form:form>

</body>
</html>