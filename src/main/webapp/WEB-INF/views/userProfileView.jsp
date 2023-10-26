<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.Objects" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/header.jsp"/>
    <title>My Profile - WinFuel</title>
    <link rel="stylesheet" href="assets/styles/userProfileView.css">

</head>

<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main>
    <%@include file="/includes/profile.jsp" %>
</main>
<jsp:include page="/includes/footer.jsp"/>

</body>

</html>