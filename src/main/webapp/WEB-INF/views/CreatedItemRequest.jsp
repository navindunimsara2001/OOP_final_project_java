<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="/includes/dashboard_header.jsp" />
<title>Title</title>
</head>
<body>
	<jsp:include page="/includes/dashboard_menu.jsp" />
	<div class="sidebar-container">
		<jsp:include page="/includes/dashboard_sidebar.jsp" />
		<main>
			<h3>Appointment Management</h3>
			<table
				class="table table-striped table-hover table-bordered table-responsive">
				<thead class="text-center">
					<tr class="table-info">
						<th>Request ID</th>
						<th>Item ID</th>
						<th>Item Name</th>
						<th>Quantity</th>
						<th>Staff ID</th>
					</tr>
				</thead>
				<tbody class="table-hover text-center">
					<c:forEach items="${itmReqList}" var="ItemRequest">
						<tr>
							<td>${ItemRequest.ID}</td>
							<td>${ItemRequest.item.ID}</td>
							<td>${Appointment.item.name}</td>
							<td>${Appointment.qty}</td>
							<td>${Appointment.staff.ID}</td>
							<td class="text-center">
								<button class="btn btn-primary edit-btn"
									data-apt-id="${Appointment.ID}"
									data-apt-approved="${Appointment.status == 'approved'}"
									data-apt-staff="${Appointment.staff.ID}">Edit</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</div>
</body>
</html>