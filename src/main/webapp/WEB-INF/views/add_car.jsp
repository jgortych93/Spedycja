<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spedycja-dodawanie samochodu</title>
</head>
<body>
<h1>
	<c:choose>
<c:when test="${carForm['id']==null}">
	Dodaj pojazd:
</c:when>
<c:otherwise>
	Edytuj pojazd:
</c:otherwise>
</c:choose>
</h1>

<form:form  modelAttribute="carForm" method="POST">

 Marka: 
 <form:input path="marka" id="marka"></form:input>
 <form:errors path="marka"/>

 <br />

 Model: 
 <form:input path="model" id="model"></form:input>
 <form:errors path="model"/>
 <br />

Pojemnosc:
 <form:input path="pojemnosc" id="pojemnosc"></form:input>


 <br />

 <c:choose>
<c:when test="${carForm['id']==null}">
<security:authorize access="hasRole('ROLE_USER')" url="/**">
 <input type="submit" value="Dodaj pojazd" />
</security:authorize>
</c:when>
<c:otherwise>
 <input type="submit" value="Edytuj pojazd" />
</c:otherwise>
</c:choose>
</form:form>

</body>
</html>