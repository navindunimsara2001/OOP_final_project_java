<%@ page import="com.model.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>Staff Dashboard</title>
    <link rel="stylesheet" href="assets/styles/staffindex.css">
</head>
<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main class="main ${sessionScope.get("role").toString().toLowerCase()}-bg">
        <div class="main-content">
            <div class="main-content-body">
                <div class="main-header">
                    <h1><b>${sessionScope.get("role").toString()} Dashboard</b></h1>
                </div>
                <div class="main-content-header">
                    <p>Welcome To The ${sessionScope.get("role").toString()} Dashboard.</p>
                </div>
                <div class="main-content-body-item">
                    <h4>You have Access to: </h4>
                </div>
                <div class="main-content-body-item">
                    <% if (session.getAttribute("role").equals(Staff.Role.Staff)) {%>
                    <ul>
                        <li><i>Request Items</i></li>
                        <li><i>Show Requested Items</i></li>
                        <li><i>Fuel Sales</i></li>
                        <li><i>Assigned Appointments</i></li>
                    </ul>
                    <%} else if (session.getAttribute("role").equals(Staff.Role.Manager)) {%>
                    <ul>
                        <li><i>Manage User profiles</i></li>
                        <li><i>View appointments</i></li>
                        <li><i>Assign staff to appointments</i></li>
                        <li><i>Manage Item Requests</i></li>
                    </ul>
                    <%} else {%>
                    <ul>
                        <li><i>Manage Users</i></li>
                        <li><i>Manage Staff</i></li>
                    </ul>
                    <%}%>
                </div>
            </div>
    </main>
</div>
</body>
</html>
