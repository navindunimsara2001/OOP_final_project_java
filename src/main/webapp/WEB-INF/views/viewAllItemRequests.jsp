<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>Requested Items</title>
</head>
<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>
        <h3>Requested Items</h3>
        <table
                class="table table-striped table-hover table-bordered table-responsive">
            <thead class="text-center">
            <tr class="table-info">
                <th>Request ID</th>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody class="table-hover text-center">
            <c:forEach items="${irList}" var="ItemRequest">
                <tr>
                    <td>${ItemRequest.ID}</td>
                    <td>${ItemRequest.item.ID}</td>
                    <td>${ItemRequest.item.name}</td>
                    <td>${ItemRequest.qty}</td>
                    <td>${ItemRequest.status}</td>
                    <td>
                   
                    <a class="btn btn-success" href="staff/ManageItemRequest?ID=${ItemRequest.ID}&status=Approve"  ${ItemRequest.status == "Pending" ? "" : "hidden"} >Approve</a>
                    <a class="btn btn-danger" href="staff/ManageItemRequest?ID=${ItemRequest.ID}&status=Deny" ${ItemRequest.status == "Pending" ? "" : "hidden"}>Deny</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>
</body>
</html>