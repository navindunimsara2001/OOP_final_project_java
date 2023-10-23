<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>Dashboard</title>
</head>

<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>
        <h3>User Management</h3>
        <table
                class="table table-striped table-hover table-bordered table-responsive">
            <thead class="text-center">
            <tr class="table-info">
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>District</th>
            </tr>
            </thead>
            <tbody class="table-hover text-center">
            <c:forEach items="${customerList}" var="Customer">
                <tr>
                    <td>${Customer.ID}</td>
                    <td>${Customer.name}</td>
                    <td>${Customer.email}</td>
                    <td>${Customer.phone}</td>
                    <td>${Customer.DOB}</td>
                    <td>${Customer.gender}</td>
                    <td>${Customer.district}</td>
                    <td class="text-center">
                        <button class="btn btn-primary">
                            <a class="text-decoration-none text-white" href="./editUser?ID=${Customer.ID}">Edit</a>
                        </button>
                        <button class="btn btn-danger">
                            <a class="text-decoration-none text-white"
                               href="./deleteUser?ID=${Customer.ID}">Delete</a>
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