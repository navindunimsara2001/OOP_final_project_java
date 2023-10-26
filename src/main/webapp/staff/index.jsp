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
    <main class="main">
        <div class="main-content">
            <div class="main-content-body">
                <div class="main-header">
                    <h1><b>${sessionScope.get("role").toString()} Dashboard</b></h1>
                </div>
                <div class="main-content-header">
                    <p>Welcome to the ${sessionScope.get("role").toString().toLowerCase()} dashboard, here you can
                        manage your account and view your bookings.</p>
                </div>
                <div class="main-content-body-item">
                    <h4>You have Access to: </h4>
                </div>
                <div class="main-content-body-item">
                    <ul>
                        <li><i>Request Items</i></li>
                        <li><i>Show Requested Items</i></li>
                        <li><i>Fuel Sales</i></li>
                        <li><i>Assigned Appointments</i></li>
                    </ul>
                </div>
    </main>
</div>
</body>
</html>
