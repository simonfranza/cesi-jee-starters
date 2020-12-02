<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Flights</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>Flightss</h2>
        <hr />

        <input type="button" value="Add survey"
               onclick="window.location.href='flight/create'; return false;"
               class="btn btn-primary" />
        <br/><br/>

        <div class="panel panel-info">
            <div class="panel-body">
                <table width="80%" border = "1" >
                    <tr style="background-color:#EAECEE">
                        <th>Code</th>
                        <th>City</th>
                        <th>Price</th>
                        <th colspan=2>Action</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="flight" items="${flights}">

                        <!-- construct an "update" link with customer id -->
                        <c:url var="updateLink" value="/flight/update">
                            <c:param name="flightId" value="${flight.id}" />
                        </c:url>

                        <!-- construct an "delete" link with customer id -->
                        <c:url var="deleteLink" value="/flight/delete">
                            <c:param name="flightId" value="${flight.id}" />
                        </c:url>

                        <tr style="border: 1px">
                            <td>${flight.id}</td>
                            <td>${flight.city}</td>
                            <td>${flight.price}</td>

                            <td>
                                <a href="${updateLink}">Update</a>
                            </td>
                            <td>
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this flight?'))) return false">Delete</a>
                            </td>
                        </tr>

                    </c:forEach>

                </table>
            </div>
        </div>
    </div>

</div>
</body>

</html>








