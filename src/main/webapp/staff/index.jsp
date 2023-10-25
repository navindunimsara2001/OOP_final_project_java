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
                    <h1><b>Staff Dashboard</b></h1>
                </div>
                <div class="main-content-header">
                    <p>Welcome to the staff dashboard, here you can manage your account and view your bookings.</p>
                </div>
                <div class="main-content-body-item">
                    <h4>You have Access to: </h4>
                </div>
                <div class="main-content-body-item">
                    <ul><i>
                        <li>Request Items</li>
                        <li>Show Requested Items</li>
                        <li>Fuel Sales</li>
                        <li>Assigned Appointments</li>
                    </i></ul>
            </div>
    </main>
</div>
</body>
</html>
