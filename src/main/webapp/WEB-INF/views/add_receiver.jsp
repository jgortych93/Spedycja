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
<c:choose>
<c:when test="${receiverForm['id']==null}">
	Dodaj odbiorce:
</c:when>
<c:otherwise>
	Edytuj odbiorce:
</c:otherwise>
</c:choose>
</h1>

<form:form action="${receiverActionUrl }" modelAttribute="receiverForm" method="POST">

 Nazwa: 
 <form:input path="name" id="name"></form:input>
 <br />
 Ulica: 
 <form:input path="street" id="street"></form:input>

 <br />

Numer:
 <form:input path="number" id="number"></form:input>

 <br />
Miasto:
 <form:input path="city" id="city"></form:input>

 <br />
Panstwo:
 <form:input path="state" id="state"></form:input>

 <br />
Kod pocztowy:
 <form:input path="zipCode" id="zipCode"></form:input>

 <br />
 <c:choose>
<c:when test="${receiverForm['id']==null}">
 <input type="submit" value="Dodaj odbiorce" />
</c:when>
<c:otherwise>
 <input type="submit" value="Edytuj odbiorce" />
</c:otherwise>
</c:choose>

</form:form>



</body>
</html>