<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	Dodaj pojazd:
</h1>
<form:form action="/wi/car/add" modelAttribute="carForm" method="POST">

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

 <input type="submit" value="Dodaj pojazd" />
</form:form>

</body>
</html>