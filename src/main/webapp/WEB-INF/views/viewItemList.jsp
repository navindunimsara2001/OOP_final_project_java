<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<h3>User Management</h3>
			<table
				class="table table-striped table-hover table-bordered table-responsive">
				<thead class="text-center">
					<tr class="table-info">
						<th>ID</th>
						<th>Name</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody class="table-hover text-center">
					<c:forEach items="${itmList}" var="Item">
						<tr>
							<td>${Item.ID}</td>
							<td>${Item.name}</td>
							<td>${Item.inStock}</td>
							<td class="text-center">
								<button class="btn btn-primary">
									<a class="text-decoration-none text-white"
										href="">Edit</a>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</div>
</body>
</html>