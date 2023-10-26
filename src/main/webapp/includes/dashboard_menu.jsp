<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="menu mini-menu fixed floating">
    <a href="staff/index.jsp" class="logo item">
        <img src="assets/images/winfuel%20connect.png" alt="Logo" height="32px">
        <b>${sessionScope.get("role")} Dashboard</b>
    </a>
    <div class="item spacer no-hover"></div>
    <a class="item" href="staff/profile"><img src="assets/images/profile.svg" width="32px" style="height: 100%"></a>
    <a href="logout" class="item no-hover">Logout</a>
</nav>
