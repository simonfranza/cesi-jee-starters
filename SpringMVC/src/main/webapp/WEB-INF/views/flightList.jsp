<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Flight reservations</title>
</head>
<body>
    <h2>flight bookings</h2>
    <a href="flight/add">Book a flight</a>

    <ul> <c:forEach items="${flights}" var="flight">
        <li>
            [<c:out value="${flight.id}" />] <br/>
            <c:out value="${flight.city}" /> <br/>
            <c:out value="${flight.price}" /> € <br/>
            <c:out value="${flight.traveller}" /> <br/>
            <a href="flight/edit?id=${flight.id}">Edit</a>
            <a href="flight/delete?id=${flight.id}">Remove</a>
        </li>
    </c:forEach>
    </ul>
</body>
</html>