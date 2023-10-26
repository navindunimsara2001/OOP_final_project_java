<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/includes/header.jsp"/>
    <link href="assets/styles/preappointments.css" rel="stylesheet" type="text/css">
    <title>My Appointments - WinFuel</title>
</head>
<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main>
    <section class="container">
        <div class="header">
            <h3>Previous Appointments</h3>
            <a class="btn btn-primary" href="user/makeAppointment.jsp"> Make Appointment</a>
        </div>
        <table
                class="table table-striped table-hover table-bordered table-responsive" id="tab">
            <thead class="text-center">
            <tr class="table-info">
                <th>ID</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Type</th>
                <th>Date</th>
                <th>Staff Id</th>
            </tr>
            </thead>
            <tbody class="table-hover text-center">
            <c:forEach items="${appList}" var="Appointment">
                <tr>
                    <td>${Appointment.ID}</td>
                    <td>${Appointment.brand}</td>
                    <td>${Appointment.model}</td>
                    <td>${Appointment.type}</td>
                    <td>${Appointment.date}</td>
                    <td>${Appointment.staff.getID()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
<jsp:include page="/includes/footer.jsp"/>
</body>
</html>