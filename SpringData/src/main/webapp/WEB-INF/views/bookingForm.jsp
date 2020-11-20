<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Book a reservation</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>Booking</h2>
        <hr />
        <form:form action="#" modelAttribute="booking" method="post">
            <c:if test="${booking.id != null}">
                traveller's ID : <form:input readonly="true" type="text" path="traveller.id" />
                <br />
            </c:if>
            First Name : <form:input type="text" path="traveller.firstName" />
            <br />
            Last Name : <form:input type="text" path="traveller.lastName" />
            <br />

            <c:if test="${booking.id != null}">
                flight's ID : <form:input readonly="true" type="text" path="flight.id" />
                <br />
            </c:if>
            City : <form:input type="text" path="flight.city" />
            <br />
            Price : <form:input type="number" path="flight.price" />
            <br />
            <button type="submit">Book a flight</button>
        </form:form>
    </div>
</div>
</body>
</html>