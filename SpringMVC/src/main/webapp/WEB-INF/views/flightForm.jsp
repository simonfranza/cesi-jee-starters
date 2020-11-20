<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Book a flight</title>
    </head>
    <body>
        <h2>Flight booking</h2>
        <form:form action="#" modelAttribute="flight" method="post">
            city : <form:input type="text" path="city" />
            <br />
            price : <form:input type="number" path="price" />
            <br />
            traveller : <form:input type="string" path="traveller" />
            <br />

            <button type="submit">${flight.id != null ? "Edit booking" : "Confirm booking"}</button>
        </form:form>
    </body>
</html>