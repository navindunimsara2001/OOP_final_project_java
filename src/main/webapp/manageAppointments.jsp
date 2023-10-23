<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Appointment Management</title>
<link rel="stylesheet" href="assets/styles/main.css">
<link rel="stylesheet" href="assets/styles/dashboard.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>

<body>
	<nav class="menu mini-menu fixed floating">
		<img class="logo" src="assets/images/winfuel connect.png" alt="Logo"
			height="32px"></img>
	</nav>
	<div class="sidebar-container">
		<aside class="sidebar">
			<div class="sidebar-up">
				<div class="sidebar-option">
					<img src="assets/images/Icons/user-search-svgrepo-com.svg"
						width="40px">
					<div class="sidebar-option-text">Users</div>
				</div>
				<div class="sidebar-option">
					<img src="assets/images/Icons/user-shield-svgrepo-com.svg"
						width="40px">
					<div class="sidebar-option-text">Managers</div>
				</div>
				<div class="sidebar-option">
					<img src="assets/images/Icons/users-svgrepo-com.svg" width="40px">
					<div class="sidebar-option-text">Staff</div>
				</div>
				<div class="sidebar-option">
					<img src="assets/images/Icons/square-list-svgrepo-com.svg"
						width="40px">
					<div class="sidebar-option-text">Appointments</div>
				</div>
				<div class="sidebar-option">
					<img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg"
						width="40px">
					<div class="sidebar-option-text">Items</div>
				</div>
			</div>
			<hr>
			<div class="sidebar-down">
				<div class="sidebar-option">
					<img src="assets/images/Icons/user-plus-svgrepo-com.svg"
						width="40px">
					<div class="sidebar-option-text">Create Manager</div>
				</div>
				<div class="sidebar-option">
					<img src="assets/images/Icons/user-plus-svgrepo-com.svg"
						width="40px">
					<div class="sidebar-option-text">Create Staff Member</div>
				</div>
			</div>
		</aside>

		<main>
			<h3>Appointment Management</h3>
			<form method="post" action="./manageAppointment">
				<table
					class="table table-striped table-hover table-bordered table-responsive">
					<thead class="text-center">
						<tr class="table-info">
							<th>ID</th>
							<th>Brand</th>
							<th>Model</th>
							<th>Year</th>
							<th>Type</th>
							<th>Date</th>
							<th>Comment</th>
							<th>Customer ID</th>
							<th>Status</th>
							<th>Assigned</th>
						</tr>
					</thead>
					<tbody class="table-hover text-center">
						<c:forEach items="${appList}" var="Appointment">
							<tr>
								<td>${Appointment.ID}</td>
								<td>${Appointment.brand}</td>
								<td>${Appointment.model}</td>
								<td>${Appointment.year}</td>
								<td>${Appointment.type}</td>
								<td>${Appointment.date}</td>
								<td>${Appointment.comment}</td>
								<td>${Appointment.cus.ID}</td>
								<td>${Appointment.status} <br> Approve : 
									<input type="checkbox" name="status" id="checkbox1"
									value="apprroved">
								</td>
								<td><select name="assigned">
										<option value="">Select Staff member</option>
										<c:forEach items="${stfList}" var="Staff">
											<option value="${Staff.ID}">
											ID : ${Staff.ID},
											Name : ${Staff.name}
											</option>
										</c:forEach>
								</select></td>
								<td class="text-center">
									<input type="hidden" name ="AID" value="${Appointment.ID}">
									<input class="btn btn-primary" type="submit" >
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</main>
	</div>

</body>

</html>