<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>My Profile - WinFuel Dashboard</title>
    <link rel="stylesheet" href="assets/styles/userProfileView.css">
    <style>
        body {
            background-image: none;
        }
    </style>
</head>
<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>
        <%@include file="/includes/profile.jsp" %>
    </main>
</div>
</body>
</html>
