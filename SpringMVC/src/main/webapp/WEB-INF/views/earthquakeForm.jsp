<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Earthquake form</title>
</head>
<body>
<h2>Create or edit an earthquake log</h2>
    <form:form action="#" modelAttribute="earthquake" method="post">
    city : <form:input type="text" path="city" />
    <br />
    Country : <form:input type="text" path="country" />
    <br />
    date : <form:input type="date" path="date" />
    <br />
    intensity : <form:input type="number" min="1" max="15" path="intensity" />
    <br />
    <button type="submit">${earthquake.id != null ? "Edit" : "Add"}</button>
    </form:form>
</body>
</html>