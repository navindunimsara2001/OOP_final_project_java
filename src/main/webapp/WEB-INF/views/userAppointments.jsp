<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<h3>Previous Appointments</h3>
		<table
			class="table table-striped table-hover table-bordered table-responsive">
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
	</main>
</body>
</html>