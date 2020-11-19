<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Hello, there</h2>
   <form:form action="#" modelAttribute="user" method="post">
        Username : <form:input type="text" path="username" />
        <br />
        Password : <form:input type="password" path="password" />
        <br />
        <button type="submit">Login</button>
    </form:form>
</body>
</html>