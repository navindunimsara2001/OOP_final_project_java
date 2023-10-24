<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="/includes/header.jsp"/>
    <title>User Login</title>
    <link rel="stylesheet" href="assets/styles/loginStyle.css">
</head>

<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main>
    <%@include file="/includes/login.jsp" %>
</main>
<jsp:include page="/includes/footer.jsp"/>

</body>

</html>