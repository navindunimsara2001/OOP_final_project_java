<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>My Assigned Appointments - WinFuel Dashboard</title>
</head>

<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>
        <h3>Assigned Appointments</h3>
        <table
                class="table table-striped table-hover table-bordered table-responsive">
            <thead class="text-center">
            <tr class="table-info">
                <th>ID</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Type</th>
                <th>Date</th>
                <th>Customer Id</th>
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
                    <td>${Appointment.cus.getID()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>

</body>

</html>