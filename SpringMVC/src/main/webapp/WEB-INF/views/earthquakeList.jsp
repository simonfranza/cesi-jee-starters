<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Earthquakes</title>
</head>
<body>
<h2>Earthquakes</h2>
<h2>Log List</h2>
<a href="earthquake/add">Add a new log</a>

<ul> <c:forEach items="${earthquakes}" var="earthquake">
    <li>
        <c:out value="${earthquake.city}" />
        <c:out value="${earthquake.country}" />
        <c:out value="${earthquake.date}" />
        <c:out value="${earthquake.intensity}" />
        <a href="earthquake/delete?id=${earthquake.id}">Remove</a>
        <a href="earthquake/edit?id=${earthquake.id}">Edit</a>
    </li>
</c:forEach>
</ul>
</body>
</html>