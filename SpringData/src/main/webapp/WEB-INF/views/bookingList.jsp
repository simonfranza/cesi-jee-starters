<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Earthquakes</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>Bookings</h2>
        <hr />

        <input type="button" value="Add survey"
               onclick="window.location.href='create'; return false;"
               class="btn btn-primary" />
        <br/><br/>

        <div class="panel panel-info">
            <div class="panel-body">
                <table width="80%" border = "1" >
                    <tr style="background-color:#EAECEE">
                        <th colspan=2>Traveller</th>
                        <th>City</th>
                        <th>Price</th>
                        <th colspan=2>Action</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="booking" items="${bookings}">

                        <!-- construct an "update" link with customer id -->
                        <c:url var="updateLink" value="/booking/update">
                            <c:param name="bookingId" value="${booking.id}" />
                        </c:url>

                        <!-- construct an "delete" link with customer id -->
                        <c:url var="deleteLink" value="/booking/delete">
                            <c:param name="bookingId" value="${booking.id}" />
                        </c:url>

                        <tr style="border: 1px">
                            <td>${booking.traveller.firstName}</td>
                            <td>${booking.traveller.lastName}</td>
                            <td>${booking.flight.city}</td>
                            <td>${booking.flight.price}</td>

                            <td>
                                <a href="${updateLink}">Update</a>
                            </td>
                            <td>
                                <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this reservation?'))) return false">Delete</a>
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








