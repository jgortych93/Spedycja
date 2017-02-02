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
<c:when test="${orderForm['id']==null}">
	Dodaj zamowienie:
</c:when>
<c:otherwise>
	Edytuj zamowienie:
</c:otherwise>
</c:choose>
</h1>

<form:form action="${orderActionUrl }" modelAttribute="orderForm" method="POST">

 Odbiorca: 
 <form:select path="sender.name" id="sederName">
 <form:options items="${senderName }" />
 </form:select>
 <br />
Nadawca: 
 <form:select path="receiver.name" id="receiverName">
 <form:options items="${receiverName }" />
 </form:select>
 <br />
Data dostawy:
 <form:input path="deliveryDate" id="deliverDate"></form:input>
 <br />
 
 Nadawca: 
 <form:select path="id_driver.username" id="userName">
 <form:options items="${userName }" />
 </form:select>
 <br />
 Waga towaru:
 <form:input path="weight" id="weight"></form:input>
 <br />
 Zawartosc przesylki:
 <form:input path="content" id="content"></form:input>
 <br />
 <c:choose>
<c:when test="${receiverForm['id']==null}">
 <input type="submit" value="Dodaj zlecenie" />
</c:when>
<c:otherwise>
 <input type="submit" value="Edytuj odbiorce" />
</c:otherwise>
</c:choose>

</form:form>



</body>
</html>