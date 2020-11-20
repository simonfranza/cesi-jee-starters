<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Register an survey</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>Earthquake logs</h2>
        <hr />

        <h2>Register an survey</h2>
        <form:form action="#" modelAttribute="survey" method="post">
            <c:if test="${survey.id != null}">
                ID : <form:input readonly="true" type="text" path="id" />
                <br />
            </c:if>
            Name : <form:input type="text" path="name" />
            <br />
            Country : <form:input type="text" path="country" />
            <br />
            Date : <form:input type="date" path="date" />
            <br />
            Magnitude : <form:input type="number" min="1" max="15" path="magnitude" />
            <br />
            <button type="submit">${survey.getId() == null ? 'Register a survey' : 'Update survey'}</button>
        </form:form>
    </div>
</div>
</body>
</html>