<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.util.URLS" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="/includes/header.jsp"/>
    <title>User Login</title>
    <link rel="stylesheet" href="assets/styles/loginStyle.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>

<body>
<section class="container">
    <header class="header">${ requestScope.get("staff") ? "Staff": "User"} Login</header>

    <div class="alert alert-danger" role="alert" ${requestScope.get("incorrect")? "": "hidden='true'"}>
        Incorrect username or password.
    </div>

    <form method="post" action="" class="form">
        <div class="input-box">
            <label for="email">Email : </label>
            <input type="text" id="email" name="email" required>
        </div>
        <div class="input-box">
            <label for="password">Password : </label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Submit</button>
        <br>

        <% if (!(boolean) request.getAttribute("staff")) { %>
        <div class="a"><a href="${URLS.USER_REGISTER}">Don't have an account?</a></div>
        <% }%>
    </form>
</section>

</body>

</html>